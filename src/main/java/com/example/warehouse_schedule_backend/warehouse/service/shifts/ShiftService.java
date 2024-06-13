package com.example.warehouse_schedule_backend.warehouse.service.shifts;

import com.example.warehouse_schedule_backend.warehouse.dto.users.request.ShiftRequest;
import com.example.warehouse_schedule_backend.warehouse.dto.users.response.ShiftResponse;
import com.example.warehouse_schedule_backend.warehouse.entity.shift.Shift;
import com.example.warehouse_schedule_backend.warehouse.repository.shift.ShiftRepository;
import com.example.warehouse_schedule_backend.warehouse.service.users.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShiftService {

    private final EmployeeService employeeService;
    ShiftRepository shiftRepository;

    public ShiftService(ShiftRepository shiftRepository, EmployeeService employeeService) {
        this.shiftRepository = shiftRepository;
        this.employeeService = employeeService;
    }

    public List<ShiftResponse> getAllShifts() {
        List<Shift> allShiftsList = shiftRepository.findAll();
        return allShiftsList.stream().map(ShiftResponse::new).toList();
    }

    public List<ShiftResponse> getShiftsByEmployeeId(Long id) {
        List<Shift> allShiftsList = shiftRepository.findShiftsByEmployeeId(id);
        return allShiftsList.stream().map(ShiftResponse::new).toList();
    }

    public List<ShiftResponse> getShiftsByEmployeeIdAndDate(Long id, LocalDate date) {
        List<Shift> specificShift = shiftRepository.findShiftsByEmployeeIdAndDate(id, date);
        return specificShift.stream().map(ShiftResponse::new).toList();
    }

    public ShiftResponse getShiftById(Long id) {
        Shift foundShift = shiftRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Shift not found"));
        return new ShiftResponse(foundShift);
    }

    public ShiftResponse createShift(ShiftRequest shiftRequest) {
        if (shiftRepository.existsByEmployeeIdAndDate(shiftRequest.getEmployeeId(), shiftRequest.getDate())) {
            System.out.println("failed 2");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This shift already exist");
        }
        Shift newShift = ShiftRequest.getShiftEntity(shiftRequest);
        newShift.setEmployee(employeeService.findEmployeeById(shiftRequest.getEmployeeId()));
        newShift = shiftRepository.save(newShift);
        return new ShiftResponse(newShift);
    }

    public void deleteShift(@PathVariable Long id) {
        shiftRepository.deleteById(id);
    }

    public void updateShift(ShiftRequest shiftRequest) {
        Shift updatedShift = shiftRepository.findById(shiftRequest.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Shift not found"));
        updatedShift.setDate(shiftRequest.getDate());
        updatedShift.setShiftStart(shiftRequest.getShiftStart());
        updatedShift.setShiftEnd(shiftRequest.getShiftEnd());
        updatedShift.setShiftDuration(shiftRequest.getShiftDuration());
        updatedShift.setComments(shiftRequest.getComments());
        shiftRepository.save(updatedShift);
    }


    public void createShifts(List<ShiftRequest> shiftRequests) {
        for (ShiftRequest shiftRequest : shiftRequests) {
            if (shiftRepository.existsByEmployeeIdAndDate(shiftRequest.getEmployeeId(), shiftRequest.getDate())) {
                System.out.println("failed");
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This shift already exist");
            }
            createShift(shiftRequest);
        }
    }
}

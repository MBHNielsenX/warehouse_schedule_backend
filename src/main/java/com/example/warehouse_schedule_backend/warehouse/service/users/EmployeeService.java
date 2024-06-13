package com.example.warehouse_schedule_backend.warehouse.service.users;

import com.example.warehouse_schedule_backend.warehouse.dto.users.request.EmployeeRequest;
import com.example.warehouse_schedule_backend.warehouse.dto.users.response.EmployeeResponse;
import com.example.warehouse_schedule_backend.warehouse.entity.users.Employee;
import com.example.warehouse_schedule_backend.warehouse.repository.users.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> allEmployeesList = employeeRepository.findAll();
        return allEmployeesList.stream().map(EmployeeResponse::new).toList();
    }

    public EmployeeResponse getEmployeeById(Long id) {
        Employee foundEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        return new EmployeeResponse(foundEmployee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        if (employeeRepository.existsByEmail(employeeRequest.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with this email already exist");
        }
        Employee newEmployee = EmployeeRequest.getEmployeeEntity(employeeRequest);
        newEmployee = employeeRepository.save(newEmployee);
        return new EmployeeResponse(newEmployee);
    }

    public void deleteEmployee(@PathVariable Long id){
        employeeRepository.deleteById(id);
    }

    public void updateEmployee(EmployeeRequest employeeRequest) {
        if (!employeeRepository.existsById(employeeRequest.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee with this ID not found");
        }
        Employee updatedEmployee = employeeRepository.findById(employeeRequest.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        if (employeeRequest.getFirstName() != null) {
            updatedEmployee.setFirstName(employeeRequest.getFirstName());
        }
        if (employeeRequest.getLastName() != null) {
            updatedEmployee.setLastName(employeeRequest.getLastName());
        }
        if (employeeRequest.getEmail() != null) {
            updatedEmployee.setEmail(employeeRequest.getEmail());
        }
        if (employeeRequest.getPhoneNumber() != null) {
            updatedEmployee.setPhoneNumber(employeeRequest.getPhoneNumber());
        }

        employeeRepository.save(updatedEmployee);
    }

}

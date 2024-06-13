package com.example.warehouse_schedule_backend.warehouse.api;

import com.example.warehouse_schedule_backend.warehouse.dto.users.request.ShiftRequest;
import com.example.warehouse_schedule_backend.warehouse.service.ExcelService;
import com.example.warehouse_schedule_backend.warehouse.service.shifts.ShiftService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/excel")
public class ExcelController {

    private final ExcelService excelService;
    private final ShiftService shiftService;

    public ExcelController(ExcelService excelService, ShiftService shiftService) {
        this.excelService = excelService;
        this.shiftService = shiftService;
    }

    @PostMapping("/upload")
    public ResponseEntity<List<ShiftRequest>> uploadExcel(@RequestParam("file")MultipartFile file) {
        List<ShiftRequest> data = excelService.readExcelFile(file);
        shiftService.createShifts(data);

        return ResponseEntity.ok(data);
    }



}

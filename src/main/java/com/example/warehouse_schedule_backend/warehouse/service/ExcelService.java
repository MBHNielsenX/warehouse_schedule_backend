package com.example.warehouse_schedule_backend.warehouse.service;

import com.example.warehouse_schedule_backend.warehouse.dto.users.request.ShiftRequest;
import com.example.warehouse_schedule_backend.warehouse.repository.shift.ShiftRepository;
import com.example.warehouse_schedule_backend.warehouse.service.shifts.ShiftService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

@Service
public class ExcelService {
    private final ShiftService shiftService;
    ShiftRepository shiftRepository;

    public ExcelService(ShiftService shiftService) {
        this.shiftService = shiftService;
    }

    public List<ShiftRequest> readExcelFile(MultipartFile file) {

        List<ShiftRequest> shiftRequests = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);

            LocalDate monday = LocalDate.parse(parseDate(sheet.getRow(0).getCell(5).getStringCellValue()));
            LocalDate tuesday = LocalDate.parse(parseDate(sheet.getRow(0).getCell(7).getStringCellValue()));
            LocalDate wednesday = LocalDate.parse(parseDate(sheet.getRow(0).getCell(9).getStringCellValue()));
            LocalDate thursday = LocalDate.parse(parseDate(sheet.getRow(0).getCell(11).getStringCellValue()));
            LocalDate friday = LocalDate.parse(parseDate(sheet.getRow(0).getCell(13).getStringCellValue()));
            LocalDate saturday = LocalDate.parse(parseDate(sheet.getRow(0).getCell(15).getStringCellValue()));
            LocalDate sunday = LocalDate.parse(parseDate(sheet.getRow(0).getCell(17).getStringCellValue()));

            for (Row currentRow: sheet) {
                if (currentRow.getRowNum() < 2) {continue;}
                if (currentRow.getCell(0) == null || currentRow.getCell(0).getCellType() == CellType.BLANK) continue;

                System.out.println("Processing row: " + currentRow.getRowNum());

                long employeeId = (long) currentRow.getCell(0).getNumericCellValue();
                System.out.println("Employee ID: " + employeeId);

                ShiftRequest mondayShift = checkShiftRequest(employeeId, currentRow.getCell(4), currentRow.getCell(5), monday);
                ShiftRequest tuesdayShift = checkShiftRequest(employeeId, currentRow.getCell(6), currentRow.getCell(7), tuesday);
                ShiftRequest wednesdayShift = checkShiftRequest(employeeId, currentRow.getCell(8), currentRow.getCell(9), wednesday);
                ShiftRequest thursdayShift = checkShiftRequest(employeeId, currentRow.getCell(10), currentRow.getCell(11), thursday);
                ShiftRequest fridayShift = checkShiftRequest(employeeId, currentRow.getCell(12), currentRow.getCell(13), friday);
                ShiftRequest saturdayShift = checkShiftRequest(employeeId, currentRow.getCell(14), currentRow.getCell(15), saturday);
                ShiftRequest sundayShift = checkShiftRequest(employeeId, currentRow.getCell(16), currentRow.getCell(17), sunday);

                if (mondayShift != null) shiftRequests.add(mondayShift);
                if (tuesdayShift != null) shiftRequests.add(tuesdayShift);
                if (wednesdayShift != null) shiftRequests.add(wednesdayShift);
                if (thursdayShift != null) shiftRequests.add(thursdayShift);
                if (fridayShift != null) shiftRequests.add(fridayShift);
                if (saturdayShift != null) shiftRequests.add(saturdayShift);
                if (sundayShift != null) shiftRequests.add(sundayShift);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (ShiftRequest shiftRequest : shiftRequests) {
            System.out.println(shiftRequest.toString());
            System.out.println("__________________________");
        }
        return shiftRequests;

    }

    private String parseDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate date = LocalDate.parse(dateStr, formatter);
            return date.toString();
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private ShiftRequest checkShiftRequest(long employeeId, Cell startCell, Cell endCell, LocalDate date) {
        if (startCell == null || endCell == null || startCell.getCellType() == CellType.BLANK || endCell.getCellType() == CellType.BLANK) {
            return null;
        }
        ShiftRequest shiftRequest = new ShiftRequest();
        shiftRequest.setEmployeeId(employeeId);
        shiftRequest.setShiftStart(startCell.getStringCellValue());
        shiftRequest.setShiftEnd(endCell.getStringCellValue());
        shiftRequest.setDate(date);
        System.out.println("ShiftRequest: " + shiftRequest.toString());
        return shiftRequest;
    }
}

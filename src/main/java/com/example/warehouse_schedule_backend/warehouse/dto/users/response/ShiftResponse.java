package com.example.warehouse_schedule_backend.warehouse.dto.users.response;

import com.example.warehouse_schedule_backend.warehouse.entity.shift.Shift;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShiftResponse {

    private Long id;

    private Long employeeId;

    private LocalDate date;

    private String shiftStart;

    private String shiftEnd;

    private String shiftDuration;

    private String comments;

    public ShiftResponse(Shift shift) {
        this.id = shift.getId();
        this.employeeId = shift.getEmployee().getId();
        this.date = shift.getDate();
        this.shiftStart = shift.getShiftStart();
        this.shiftEnd = shift.getShiftEnd();
        this.shiftDuration = shift.getShiftDuration();
        this.comments = shift.getComments();
    }
}

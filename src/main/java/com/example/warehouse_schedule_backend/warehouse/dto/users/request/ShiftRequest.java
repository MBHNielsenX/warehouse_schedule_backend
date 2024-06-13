package com.example.warehouse_schedule_backend.warehouse.dto.users.request;


import com.example.warehouse_schedule_backend.warehouse.entity.shift.Shift;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShiftRequest {

    private Long id;

    private LocalDate date;

    private String shiftStart;

    private String shiftEnd;

    private String shiftDuration;

    private String comments;

    private Long employeeId;

    public static Shift getShiftEntity(ShiftRequest shiftRequest){
        return Shift.shiftBuilder()
            .date(shiftRequest.getDate())
            .shiftStart(shiftRequest.getShiftStart())
            .shiftEnd(shiftRequest.getShiftEnd())
            .shiftDuration(shiftRequest.getShiftDuration())
            .comments(shiftRequest.getComments())
            .build();
    }

    public ShiftRequest(Shift shift){
        this.id = shift.getId();
        this.date = shift.getDate();
        this.shiftStart = shift.getShiftStart();
        this.shiftEnd = shift.getShiftEnd();
        this.shiftDuration = shift.getShiftDuration();
        this.comments = shift.getComments();
    }
}

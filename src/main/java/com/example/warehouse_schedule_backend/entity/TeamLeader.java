package com.example.warehouse_schedule_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "team_leader")
public class TeamLeader extends Employee{

    private boolean canEditSchedule;



    @Builder()
    public TeamLeader(Long id, String employeeNumber, String password, String firstName, String lastName, String phoneNumber, boolean canEditSchedule) {
        super(id, employeeNumber, password, firstName, lastName, phoneNumber);
        this.canEditSchedule = canEditSchedule;
    }





}

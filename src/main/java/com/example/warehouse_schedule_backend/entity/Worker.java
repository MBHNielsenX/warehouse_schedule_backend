package com.example.warehouse_schedule_backend.entity;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "worker")
public class Worker extends Employee{

    @Builder()
    public Worker(Long id, String employeeNumber, String password, String firstName, String lastName, String phoneNumber, boolean canEditSchedule) {
        super(id, employeeNumber, password, firstName, lastName, phoneNumber);
    }

}

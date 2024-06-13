package com.example.warehouse_schedule_backend.warehouse.entity.shift;

import com.example.warehouse_schedule_backend.warehouse.entity.users.Employee;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "shift")


public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shift_id")
    private Long id;

    @Column(length = 100, nullable = false)
    private LocalDate date;

    @Column(length = 100, nullable = false)
    private String shiftStart;

    @Column(length = 100, nullable = false)
    private String shiftEnd;

    @Column(length = 100,columnDefinition = "varchar(255) default 'No Value'")
    private String shiftDuration;

    @Column(length = 100,columnDefinition = "varchar(255) default 'No Value'")
    private String comments;

    @ManyToOne()
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Builder(builderMethodName = "shiftBuilder")
    public Shift (Long id, LocalDate date, String shiftStart, String shiftEnd, String shiftDuration, String comments, Employee employee) {
        this.id = id;
        this.date = date;
        this.shiftStart = shiftStart;
        this.shiftEnd = shiftEnd;
        this.shiftDuration = shiftDuration;
        this.comments = comments;
        this.employee = employee;
    }

}

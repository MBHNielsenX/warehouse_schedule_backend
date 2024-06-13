package com.example.warehouse_schedule_backend.warehouse.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "schedule")
@SuperBuilder

public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false,columnDefinition = "varchar(255) default 'No Value'")
    private String scheduleMonth;

    @Column(length = 100, nullable = false,columnDefinition = "varchar(255) default 'No Value'")
    private int scheduleYear;
}

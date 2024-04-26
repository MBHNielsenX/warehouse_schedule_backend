package com.example.warehouse_schedule_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Shift")
@SuperBuilder

public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false,columnDefinition = "varchar(255) default 'No Value'")
    private String dayOfWeek;

    @Column(length = 100, nullable = false,columnDefinition = "varchar(255) default 'No Value'")
    private String shiftStart;

    @Column(length = 100, nullable = false,columnDefinition = "varchar(255) default 'No Value'")
    private String shiftEnd;

    @Column(length = 100, nullable = false,columnDefinition = "varchar(255) default 'No Value'")
    private String shiftDuration;

    @Column(length = 100, nullable = false,columnDefinition = "varchar(255) default 'No Value'")
    private String shiftType;

    @Column(length = 100, nullable = false,columnDefinition = "varchar(255) default 'No Value'")
    private String comments;

    @ManyToOne(cascade = CascadeType.ALL)
    private Schedule schedule;

}

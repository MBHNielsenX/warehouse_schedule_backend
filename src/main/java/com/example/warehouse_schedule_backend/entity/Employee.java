package com.example.warehouse_schedule_backend.entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "employees")
@SuperBuilder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false,columnDefinition = "varchar(255) default 'No Value'")
    private String employeeNumber;

    @Column(length = 100, nullable = false,columnDefinition = "varchar(255) default 'No Value'")
    private String password;

    @Column(length = 100, nullable = false,columnDefinition = "varchar(255) default 'No Value'")
    private String firstName;

    @Column(length = 100, nullable = false,columnDefinition = "varchar(255) default 'No Value'")
    private String lastName;

    @Column(length = 100, nullable = false,columnDefinition = "varchar(255) default 'No Value'")
    private String phoneNumber;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime edited;


    public Employee(Long id, String employeeNumber, String password, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.employeeNumber = employeeNumber;
        setPassword(password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    //encoded at a later time
    public void setPassword(String pw) {
        this.password = pw;
    }

}

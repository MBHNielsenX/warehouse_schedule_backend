package com.example.warehouse_schedule_backend.warehouse.dto.users.request;

import com.example.warehouse_schedule_backend.warehouse.entity.users.Employee;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeRequest {

    private Long id;

    private Long employeeNumber;

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    private String phoneNumber;

    public static Employee getEmployeeEntity(EmployeeRequest u){
        return Employee.employeeBuilder()
            .employeeNumber(u.getEmployeeNumber())
            .firstName(u.getFirstName())
            .lastName(u.getLastName())
            .password(u.getPassword())
            .phoneNumber(u.getPhoneNumber())
            .email(u.getEmail())
            .build();
    }

    public EmployeeRequest(Employee u){
        this.id = u.getId();
        this.firstName = u.getFirstName();
        this.lastName = u.getLastName();
        this.email = u.getEmail();
        this.phoneNumber = u.getPhoneNumber();
        this.password = u.getPassword();
        this.employeeNumber = u.getEmployeeNumber();


    }
}

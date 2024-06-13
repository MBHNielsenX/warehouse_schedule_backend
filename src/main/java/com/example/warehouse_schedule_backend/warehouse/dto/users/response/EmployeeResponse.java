package com.example.warehouse_schedule_backend.warehouse.dto.users.response;

import com.example.warehouse_schedule_backend.warehouse.entity.enums.Area;
import com.example.warehouse_schedule_backend.warehouse.entity.users.Employee;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse {

    private Long id;

    private Long employeeNumber;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String schedule;

    private String contractHours;

    private Enum<Area> area;



    public EmployeeResponse(Employee employee) {
        this.id = employee.getId();
        this.employeeNumber = employee.getEmployeeNumber();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.email = employee.getEmail();
        this.phoneNumber = employee.getPhoneNumber();
        this.contractHours = employee.getContractHours();
        this.area = employee.getArea();
    }

}

package com.example.warehouse_schedule_backend.warehouse.entity.users;
import com.example.warehouse_schedule_backend.warehouse.entity.shift.Shift;
import com.example.warehouse_schedule_backend.warehouse.entity.enums.Area;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "employee")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column(length = 100, nullable = false,columnDefinition = "varchar(255) default 'No Value'")
    private Long employeeNumber;

    @Column(length = 100, nullable = false,columnDefinition = "varchar(255) default 'No Value'")
    private String password;

    @Column(length = 100, nullable = false,columnDefinition = "varchar(255) default 'No Value'")
    private String firstName;

    @Column(length = 100, nullable = false,columnDefinition = "varchar(255) default 'No Value'")
    private String lastName;

    @Column(length = 100, nullable = false,columnDefinition = "varchar(255) default 'No Value'")
    private String email;

    @Column(length = 100, nullable = false,columnDefinition = "varchar(255) default 'No Value'")
    private String phoneNumber;

    @OneToMany(mappedBy = "employee")
    private List<Shift> shifts;

    @Column(length = 100,columnDefinition = "varchar(255) default 'No Value'")
    private String contractHours;

    @Enumerated(EnumType.STRING)
    @Column(length = 100)
    private Area area;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime edited;

    @Builder(builderMethodName = "employeeBuilder")
    public Employee(Long id, Long employeeNumber, String password, String firstName, String lastName, String email, String phoneNumber, String contractHours, Area area){
        this.id = id;
        this.employeeNumber = employeeNumber;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.contractHours = contractHours;
        this.area = area;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    /*
    public Employee(Long id, String employeeNumber, String password, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.employeeNumber = employeeNumber;
        setPassword(password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

     */
/*
    //encoded at a later time
    public void setPassword(String pw) {
        this.password = pw;
    }

 */

}

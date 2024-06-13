package com.example.warehouse_schedule_backend.warehouse.repository.users;

import com.example.warehouse_schedule_backend.warehouse.entity.users.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByEmail(String email);
}

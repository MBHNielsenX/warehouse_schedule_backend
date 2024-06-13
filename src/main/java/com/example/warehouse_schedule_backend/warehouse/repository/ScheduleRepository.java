package com.example.warehouse_schedule_backend.warehouse.repository;

import com.example.warehouse_schedule_backend.warehouse.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}

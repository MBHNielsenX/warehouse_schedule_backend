package com.example.warehouse_schedule_backend.warehouse.configuration;

import com.example.warehouse_schedule_backend.warehouse.entity.shift.Shift;
import com.example.warehouse_schedule_backend.warehouse.entity.users.Employee;
import com.example.warehouse_schedule_backend.warehouse.repository.ScheduleRepository;
import com.example.warehouse_schedule_backend.warehouse.repository.shift.ShiftRepository;
import com.example.warehouse_schedule_backend.warehouse.repository.users.EmployeeRepository;
import lombok.SneakyThrows;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

@Controller
public class setupUsers implements ApplicationRunner{

    private final EmployeeRepository employeeRepository;
    private final ScheduleRepository scheduleRepository;
    private final ShiftRepository shiftRepository;

    public setupUsers(EmployeeRepository employeeRepository, ScheduleRepository scheduleRepository, ShiftRepository shiftRepository) {
        this.employeeRepository = employeeRepository;
        this.scheduleRepository = scheduleRepository;
        this.shiftRepository = shiftRepository;
    }

        @SneakyThrows
        @Override
        public void run(ApplicationArguments args) {
            Employee employee1 = Employee.employeeBuilder()
                    .employeeNumber(1L)
                    .firstName("Alfred")
                    .lastName("Alfy")
                    .email("Alfred@mail.com")
                    .password("password")
                    .phoneNumber("12345678")
                    .contractHours("37")
                    .build();

            employeeRepository.save(employee1);

            Employee employee2 = Employee.employeeBuilder()
                    .employeeNumber(2L)
                    .firstName("Benny")
                    .lastName("Benson")
                    .email("Benny.benson@mail.com")
                    .password("password")
                    .phoneNumber("87654321")
                    .contractHours("37")
                    .build();

            employeeRepository.save(employee2);

            Employee employee3 = Employee.employeeBuilder()
                    .employeeNumber(3L)
                    .firstName("Carlos")
                    .lastName("Carlson")
                    .email("Carlos.carlson@mail.com")
                    .password("password")
                    .phoneNumber("87654321")
                    .contractHours("37")
                    .build();

            employeeRepository.save(employee3);

            Employee employee4 = Employee.employeeBuilder()
                    .employeeNumber(4L)
                    .firstName("Danny")
                    .lastName("Dansen")
                    .email("Danny.Dansen@mail.com")
                    .password("password")
                    .phoneNumber("87654321")
                    .contractHours("37")
                    .build();

            employeeRepository.save(employee4);

            Employee employee5 = Employee.employeeBuilder()
                    .employeeNumber(5L)
                    .firstName("Eddy")
                    .lastName("Eddyson")
                    .email("Eddy.Eddyson@mail.com")
                    .password("password")
                    .phoneNumber("87654321")
                    .contractHours("37")
                    .build();

            employeeRepository.save(employee5);

            Employee employee6 = Employee.employeeBuilder()
                    .employeeNumber(6L)
                    .firstName("Fredderik")
                    .lastName("Freddyson")
                    .email("Fredderik.Freddyson@mail.com")
                    .password("password")
                    .phoneNumber("87654321")
                    .contractHours("37")
                    .build();

            employeeRepository.save(employee6);

            Employee employee7 = Employee.employeeBuilder()
                    .employeeNumber(7L)
                    .firstName("Gertrud")
                    .lastName("Gertrudson")
                    .email("Gertrud.Gertrudson@mail.com")
                    .password("password")
                    .phoneNumber("87654321")
                    .contractHours("37")
                    .build();

            employeeRepository.save(employee7);

            Employee employee8 = Employee.employeeBuilder()
                    .employeeNumber(8L)
                    .firstName("Hans")
                    .lastName("Hansen")
                    .email("Hans.Hansen@mail.com")
                    .password("password")
                    .phoneNumber("87654321")
                    .contractHours("37")
                    .build();

            employeeRepository.save(employee8);

            Employee employee9 = Employee.employeeBuilder()
                    .employeeNumber(9L)
                    .firstName("Inger")
                    .lastName("Ingerson")
                    .email("Inger.Ingerson@mail.com")
                    .password("password")
                    .phoneNumber("87654321")
                    .contractHours("37")
                    .build();

            employeeRepository.save(employee9);

            Employee employee10 = Employee.employeeBuilder()
                    .employeeNumber(10L)
                    .firstName("Jens")
                    .lastName("Jensen")
                    .email("Jens.Jensen@mail.com")
                    .password("password")
                    .phoneNumber("87654321")
                    .contractHours("37")
                    .build();

            employeeRepository.save(employee10);

            Employee employee11 = Employee.employeeBuilder()
                    .employeeNumber(11L)
                    .firstName("Klaus")
                    .lastName("Deichman")
                    .email("Klaus.Deichman@mail.com")
                    .password("password")
                    .phoneNumber("87654321")
                    .contractHours("37")
                    .build();

            employeeRepository.save(employee11);

            Employee employee12 = Employee.employeeBuilder()
                    .employeeNumber(12L)
                    .firstName("Lars")
                    .lastName("Nielsen")
                    .email("Lars.Nielsen@mail.com")
                    .password("password")
                    .phoneNumber("87654321")
                    .contractHours("37")
                    .build();

            employeeRepository.save(employee12);

            Employee employee13 = Employee.employeeBuilder()
                    .employeeNumber(13L)
                    .firstName("Mads")
                    .lastName("Bøgh")
                    .email("Mads.Bøgh@mail.com")
                    .password("password")
                    .phoneNumber("87654321")
                    .contractHours("37")
                    .build();

            employeeRepository.save(employee13);

            Employee employee14 = Employee.employeeBuilder()
                    .employeeNumber(14L)
                    .firstName("Nichlas")
                    .lastName("Kjær")
                    .email("Nichlas.Kjær@mail.com")
                    .password("password")
                    .phoneNumber("87654321")
                    .contractHours("37")
                    .build();

            employeeRepository.save(employee14);

            Employee employee15 = Employee.employeeBuilder()
                    .employeeNumber(15L)
                    .firstName("Oskar")
                    .lastName("Hansley")
                    .email("Oskar.Hansley@mail.com")
                    .password("password")
                    .phoneNumber("87654321")
                    .contractHours("37")
                    .build();

            employeeRepository.save(employee15);

            Employee employee16 = Employee.employeeBuilder()
                    .employeeNumber(16L)
                    .firstName("Paul")
                    .lastName("Cormwell")
                    .email("Paul.Cormwell@mail.com")
                    .password("password")
                    .phoneNumber("87654321")
                    .contractHours("37")
                    .build();

            employeeRepository.save(employee16);

            Employee employee17 = Employee.employeeBuilder()
                    .employeeNumber(17L)
                    .firstName("Quinn")
                    .lastName("Monroe")
                    .email("Quinn.Monroe@mail.com")
                    .password("password")
                    .phoneNumber("87654321")
                    .contractHours("37")
                    .build();

            employeeRepository.save(employee17);

            Employee employee18 = Employee.employeeBuilder()
                    .employeeNumber(18L)
                    .firstName("Ralf")
                    .lastName("Madison")
                    .email("Ralf.Madison@mail.com")
                    .password("password")
                    .phoneNumber("87654321")
                    .contractHours("37")
                    .build();

            employeeRepository.save(employee18);

            Employee employee19 = Employee.employeeBuilder()
                    .employeeNumber(19L)
                    .firstName("Steen")
                    .lastName("Adler")
                    .email("Steen.Adler@mail.com")
                    .password("password")
                    .phoneNumber("87654321")
                    .contractHours("37")
                    .build();

            employeeRepository.save(employee19);

            Employee employee20 = Employee.employeeBuilder()
                    .employeeNumber(20L)
                    .firstName("Tina")
                    .lastName("Huxley")
                    .email("Tina.Huxley@mail.com")
                    .password("password")
                    .phoneNumber("87654321")
                    .contractHours("37")
                    .build();

            employeeRepository.save(employee20);

            Employee employee21 = Employee.employeeBuilder()
                    .employeeNumber(21L)
                    .firstName("Unni")
                    .lastName("Ledger")
                    .email("Unni.Ledger@mail.com")
                    .password("password")
                    .phoneNumber("87654321")
                    .contractHours("37")
                    .build();

            employeeRepository.save(employee21);

            Employee employee22 = Employee.employeeBuilder()
                    .employeeNumber(22L)
                    .firstName("Vinzent")
                    .lastName("Gatlin")
                    .email("Vinzent.Gatlin@mail.com")
                    .password("password")
                    .phoneNumber("87654321")
                    .contractHours("37")
                    .build();

            employeeRepository.save(employee22);

            Shift shift1 = Shift.shiftBuilder()
                    .date(LocalDate.of(2021, 12, 1))
                    .shiftStart("06:00")
                    .shiftEnd("14:00")
                    .employee(employee1)
                    .build();

            shiftRepository.save(shift1);

            Shift shift2 = Shift.shiftBuilder()
                    .date(LocalDate.of(2021, 12, 1))
                    .shiftStart("06:00")
                    .shiftEnd("14:00")
                    .employee(employee2)
                    .build();

            shiftRepository.save(shift2);

            Shift shift3 = Shift.shiftBuilder()
                    .date(LocalDate.of(2021, 12, 2))
                    .shiftStart("06:00")
                    .shiftEnd("14:00")
                    .employee(employee2)
                    .build();

            shiftRepository.save(shift3);




        }


}

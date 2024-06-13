package com.example.warehouse_schedule_backend.users;

import com.example.warehouse_schedule_backend.warehouse.dto.users.request.EmployeeRequest;
import com.example.warehouse_schedule_backend.warehouse.dto.users.response.EmployeeResponse;
import com.example.warehouse_schedule_backend.warehouse.entity.enums.Area;
import com.example.warehouse_schedule_backend.warehouse.entity.users.Employee;
import com.example.warehouse_schedule_backend.warehouse.repository.users.EmployeeRepository;
import com.example.warehouse_schedule_backend.warehouse.service.users.EmployeeService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class EmployeeServiceTest {

    public EmployeeService employeeService;

    public static EmployeeRepository employeeRepository;

    static int employeeSize;


    @BeforeAll
    public static void setUp(@Autowired EmployeeRepository employee_Repository) {
        employeeRepository = employee_Repository;
        employeeRepository.deleteAll();

        List<Employee> employeeList = List.of(
                Employee.employeeBuilder()
                        .id(1L)
                        .employeeNumber(1L)
                        .password("1234")
                        .firstName("Peter")
                        .lastName("Parker")
                        .email("Peter.Parker@mail.dk")
                        .phoneNumber("12345678")
                        .contractHours("37")
                        .area(Area.CHILLER)
                        .build(),
                Employee.employeeBuilder()
                        .id(2L)
                        .employeeNumber(2L)
                        .password("1234")
                        .firstName("Bruce")
                        .lastName("Wayne")
                        .email("Bruce.Wayne@mail.dk")
                        .phoneNumber("87654321")
                        .contractHours("37")
                        .area(Area.FG)
                        .build(),
                Employee.employeeBuilder()
                        .id(3L)
                        .employeeNumber(3L)
                        .password("1234")
                        .firstName("Clark")
                        .lastName("Kent")
                        .email("Clark.Kent@mail.dk")
                        .phoneNumber("12348765")
                        .contractHours("37")
                        .area(Area.AMBIENT)
                        .build(),
                Employee.employeeBuilder()
                        .id(4L)
                        .employeeNumber(4L)
                        .password("1234")
                        .firstName("Diana")
                        .lastName("Prince")
                        .email("Diana.Prince@mail.dk")
                        .phoneNumber("87651234")
                        .contractHours("15")
                        .area(Area.FLYER)
                        .build());

        employeeRepository.saveAll(employeeList);
        employeeSize = employeeRepository.findAll().size();
    }

    @BeforeEach
    public void setEmployeeService() {
        employeeService = new EmployeeService(employeeRepository);
    }

    @Test
    public void getAllEmployees() {
        int actualResult = employeeRepository.findAll().size();
        int expectedResult = employeeSize;

        int actualResultService = employeeService.getAllEmployees().size();

        assertEquals(expectedResult, actualResult);
        assertEquals(expectedResult, actualResultService);
    }

    @Test
    public void getEmployeeById() {
        EmployeeResponse employeeResponse = employeeService.getEmployeeById(1L);
        String actualResult = employeeResponse.getFirstName();
        String expectedResult = "Peter";
        assertEquals(expectedResult, actualResult);

        employeeResponse = employeeService.getEmployeeById(2L);
        actualResult = employeeResponse.getFirstName();
        expectedResult = "Bruce";
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void createEmployee() {
        String expectedFirstName = "Barry";
        Employee newEmployee = Employee.employeeBuilder()
            .id(5L)
            .employeeNumber(5L)
            .password("1234")
            .firstName(expectedFirstName)
            .lastName("Allen")
            .email("Barry.Allen@mail.dk")
            .phoneNumber("12345678")
            .build();

        employeeService.createEmployee(new EmployeeRequest(newEmployee));
        int actualResult = employeeRepository.findAll().size();
        int expectedResult = employeeSize + 1;
        String actualEmployeeNumber = newEmployee.getEmployeeNumber().toString();
        int actualResultService = employeeService.getAllEmployees().size();
        String actualEmployeeNumberService = employeeService.getEmployeeById(5L).getEmployeeNumber().toString();

        assertEquals(expectedResult, actualResult);
        assertEquals(expectedResult, actualResultService);
        assertEquals(actualEmployeeNumber, actualEmployeeNumberService);
    }

    @Test
    public void updateEmployee() {
        Employee foundEmployee = employeeRepository.findById(1L).orElseThrow();
        String firstNameBefore = foundEmployee.getFirstName();
        String newFirstName = "Miles";
        String areaBefore = foundEmployee.getArea().toString();
        Area newArea = Area.FLYER;
        String contractHoursBefore = foundEmployee.getContractHours();
        String newContractHours = "20";
        Optional<Employee> employeeToEdit = employeeRepository.findById(1L);

        if (employeeToEdit.isPresent()) {
            Employee updatedEmployee = employeeToEdit.get();
            updatedEmployee.setFirstName(newFirstName);
            updatedEmployee.setArea(newArea);
            updatedEmployee.setContractHours(newContractHours);

            EmployeeRequest employeeRequest = new EmployeeRequest(updatedEmployee);
            employeeService.updateEmployee(employeeRequest);
        }

        String firstNameAfter = employeeRepository.findById(1L).orElseThrow().getFirstName();
        String areaAfter = employeeRepository.findById(1L).orElseThrow().getArea().toString();
        String contractHoursAfter = employeeRepository.findById(1L).orElseThrow().getContractHours();

        assertEquals(newFirstName, firstNameAfter);
        assertEquals(newArea.toString(), areaAfter);
        assertEquals(newContractHours, contractHoursAfter);
        assertNotEquals(firstNameBefore, firstNameAfter);
        assertNotEquals(areaBefore, areaAfter);
        assertNotEquals(contractHoursBefore, contractHoursAfter);

    }

    @Test
    public void deleteEmployee() {
        employeeService.deleteEmployee(1L);
        int actualResult = employeeRepository.findAll().size();
        int expectedResult = employeeSize - 1;
        assertEquals(expectedResult, actualResult);
    }


}

package com.app;

import com.app.manager.EmployeeManager;
import com.app.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ApplicationTests {

    private EmployeeManager employeeManager;

    @BeforeEach
    void setUp() {
        this.employeeManager = new EmployeeManager();
        Employee newEmployee = new Employee("djones3", "Daria", "Jones", "dariajones@gmail.com", "Software developer");
        this.employeeManager.addEmployee(newEmployee);
    }

    @Test
    void createEmployeeManager() {
        EmployeeManager newEmployeeManager = new EmployeeManager();
        assertNotNull(newEmployeeManager.getAllEmployees());
        assertTrue(newEmployeeManager.getAllEmployees().getEmployeeList().size() > 0);
    }

    @Test
    void addEmployee() {
        int employeeCount = employeeManager.getAllEmployees().getEmployeeList().size();
        Employee employee = new Employee("jdoe", "John", "Doe", "john.doe@example.com", "Engineer");
        employeeManager.addEmployee(employee);
        assertEquals(employeeCount + 1, employeeManager.getAllEmployees().getEmployeeList().size());
    }

    @Test
    void employeeIdInList() {
        List<Employee> employees = employeeManager.getAllEmployees().getEmployeeList();
        assertTrue(employees.stream().anyMatch(employee -> employee.getEmployee_id().equals("djones3")));
    }

    @Test
    void employeeFirstNameInList() {
        List<Employee> employees = employeeManager.getAllEmployees().getEmployeeList();
        assertTrue(employees.stream().anyMatch(employee -> employee.getFirst_name().equals("Daria")));
    }

    @Test
    void employeeLastNameInList() {
        List<Employee> employees = employeeManager.getAllEmployees().getEmployeeList();
        assertTrue(employees.stream().anyMatch(employee -> employee.getLast_name().equals("Jones")));
    }

    @Test
    void employeeEmailInList() {
        List<Employee> employees = employeeManager.getAllEmployees().getEmployeeList();
        assertTrue(employees.stream().anyMatch(employee -> employee.getEmail().equals("dariajones@gmail.com")));
    }

    @Test
    void employeeTitleInList() {
        List<Employee> employees = employeeManager.getAllEmployees().getEmployeeList();
        assertTrue(employees.stream().anyMatch(employee -> employee.getTitle().equals("Software developer")));
    }
}

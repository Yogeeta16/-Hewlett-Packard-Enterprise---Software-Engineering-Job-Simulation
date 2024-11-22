package com.app.manager;

import com.app.model.Employee;
import com.app.model.Employees;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {

    private final List<Employee> employeeList;

    // Constructor to initialize the employee list
    public EmployeeManager() {
        this.employeeList = new ArrayList<>();
        this.employeeList.add(new Employee("1", "John", "Doe", "john.doe@example.com", "Software Engineer"));
        this.employeeList.add(new Employee("2", "Jane", "Smith", "jane.smith@example.com", "Product Manager"));
        this.employeeList.add(new Employee("3", "Alice", "Johnson", "alice.johnson@example.com", "UX Designer"));
    }

    // Method to get all employees
    public Employees getAllEmployees() {
        Employees employees = new Employees();
        employees.setEmployeeList(employeeList);
        return employees;
    }

    // Method to add a new employee
    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);
    }
}

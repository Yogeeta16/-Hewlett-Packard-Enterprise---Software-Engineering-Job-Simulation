package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {

	private List<Employee> employees = new ArrayList<>(Arrays.asList(
	        new Employee("123", "John", "Doe", "john.doe@example.com", "Developer"),
	        new Employee("124", "Jane", "Smith", "jane.smith@example.com", "Manager"),
	        new Employee("125", "Bob", "Johnson", "bob.johnson@example.com", "Designer")
	));


    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employees;
    }

    @PostMapping("/employees")
    public String addEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return "Employee added successfully!";
    }
}

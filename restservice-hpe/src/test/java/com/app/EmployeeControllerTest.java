package com.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.app.controller.EmployeeController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new EmployeeController()).build();
    }

    @Test
    void testGetEmployees() throws Exception {
        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())  // Check if the response is an array
                .andExpect(jsonPath("$.length()").value(3));  // Assuming you have 3 employees
    }

    @Test
    void testAddEmployee() throws Exception {
        String newEmployeeJson = "{\"employee_id\": \"456\", \"first_name\": \"Alice\", \"last_name\": \"Brown\", \"email\": \"alice.brown@example.com\", \"title\": \"Analyst\"}";

        mockMvc.perform(post("/employees")
                .contentType("application/json")
                .content(newEmployeeJson))
                .andExpect(status().isOk())
                .andExpect(content().string("Employee added successfully!"));
    }
}

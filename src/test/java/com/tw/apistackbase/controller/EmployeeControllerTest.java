package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;



@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    EmployeeService employeeService;

    @Test
    public void should_return_employee_when_invoke_find_given_id() throws Exception {
        Employee employee = new Employee();
        employee.setId("1111");
        employee.setName("lay");
        employee.setGender("Male");
        employee.setAge(18);

        when(employeeService.getId(anyString())).thenReturn(employee);

        ResultActions result = mockMvc.perform(get("/employeeController/employees/{id}",employee.getId()));

        result.andExpect(status().isOk()).andExpect(jsonPath("$.name",is("lay")))
                .andExpect(jsonPath("$.age",is(18)))
                .andExpect(jsonPath("$.gender",is("Male")))
                .andExpect(jsonPath("$.id",is("1111")));
    }
}
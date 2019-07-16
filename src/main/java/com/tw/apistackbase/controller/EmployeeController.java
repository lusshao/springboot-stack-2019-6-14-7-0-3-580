package com.tw.apistackbase.controller;

import com.tw.apistackbase.Repository.EmployeeRepository;
import com.tw.apistackbase.Repository.IEmployeeRepository;
import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("employeeController")
public class EmployeeController {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> list(){
        return employeeService.list();
    }

    @GetMapping("/employees/{id}")
    public Employee getId(@PathVariable String id){
        return employeeService.getId(id);
    }

    @PostMapping("/employees")
    public Employee getNewEmployee(@RequestBody Employee employee){
        return employeeService.getNewEmployee(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public Employee deleteEmployee(@PathVariable String employeeId){
        return employeeService.deleteEmployee(employeeId);
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@RequestBody Employee employee,@PathVariable String employeeId){
        employee.setId(employeeId);
        return employeeService.updateEmployee(employee);
    }

    @GetMapping("/employees/age/{findAge}")
    public List<Employee> findEmployeeSmallerThanAge(@PathVariable int findAge){
        return employeeService.findEmployeeSmallerThanAge(findAge);
    }


}
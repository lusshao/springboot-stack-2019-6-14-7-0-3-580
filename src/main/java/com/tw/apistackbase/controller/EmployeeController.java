package com.tw.apistackbase.controller;

import com.tw.apistackbase.Repository.EmployeeRepository;
import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("employeeController")
public class EmployeeController {

    private final Logger log = Logger.getLogger(this.getClass().getName());
    EmployeeRepository repository = new EmployeeRepository();

    @GetMapping("/employees")
    public List<Employee> list(){
        return repository.getEmployeeList();
    }

    @GetMapping("/employees/{id}")
    public Employee getId(@PathVariable String id){
        return repository.getEmployeeById(id);
    }

    @PostMapping("/employees")
    public Employee getNewEmployee(@RequestBody Employee employee){
        return repository.addNewEmployee(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public Employee deleteEmployee(@PathVariable String employeeId){
        return repository.deleteEmployee(employeeId);
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@RequestBody Employee employee,@PathVariable String employeeId){
        employee.setId(employeeId);
        return repository.updateEmployee(employee);
    }

    @GetMapping("/employees/age/{findAge}")
    public List<Employee> findEmployeeSmallerThanAge(@PathVariable int findAge){
        return repository.outEmployeeSmallerThanAge(findAge);
    }


}
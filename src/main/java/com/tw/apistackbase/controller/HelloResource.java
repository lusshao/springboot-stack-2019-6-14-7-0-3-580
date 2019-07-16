package com.tw.apistackbase.controller;

import com.tw.apistackbase.Repository.EmployeeRepository;
import com.tw.apistackbase.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by jxzhong on 18/08/2017.
 */
@RestController
@RequestMapping("hello")
public class HelloResource {

    private final Logger log = Logger.getLogger(this.getClass().getName());
    EmployeeRepository repository = new EmployeeRepository();

    @GetMapping("/employees")
    public List<Employee> list(){
        return repository.getEmployeeList();
    }


}

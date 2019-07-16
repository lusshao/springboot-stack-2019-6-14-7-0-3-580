package com.tw.apistackbase.service;

import com.tw.apistackbase.Repository.EmployeeRepository;
import com.tw.apistackbase.Repository.IEmployeeRepository;
import com.tw.apistackbase.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> list(){
        return employeeRepository.getEmployeeList();
    }

    public Employee getId(@PathVariable String id){
        return employeeRepository.getEmployeeById(id);
    }

    public Employee getNewEmployee(@RequestBody Employee employee){
        return employeeRepository.addNewEmployee(employee);
    }

    public Employee deleteEmployee(@PathVariable String employeeId){
        return employeeRepository.deleteEmployee(employeeId);
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.updateEmployee(employee);
    }

    public List<Employee> findEmployeeSmallerThanAge(int findAge){
        return employeeRepository.outEmployeeSmallerThanAge(findAge);
    }


}

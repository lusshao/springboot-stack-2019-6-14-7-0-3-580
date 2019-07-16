package com.tw.apistackbase.Repository;


import com.tw.apistackbase.model.Employee;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public interface IEmployeeRepository {
    public List<Employee> getEmployeeList();
    public Employee getEmployeeById(String id);

    public Employee addNewEmployee(Employee employee);

    public Employee deleteEmployee(String employeeId);

    public Employee updateEmployee(Employee employee);
    public List<Employee> outEmployeeSmallerThanAge(int age);
}

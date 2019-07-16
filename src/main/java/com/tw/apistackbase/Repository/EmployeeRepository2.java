package com.tw.apistackbase.Repository;

import com.tw.apistackbase.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository2 implements IEmployeeRepository {
    private static List<Employee> employeeList;
    static{
        employeeList = new ArrayList<>();
        Employee employee = new Employee();
        employeeList.add(createEmployee("1111"));
        employeeList.add(createEmployee("2222"));
        employeeList.add(createEmployee("3333"));
        employeeList.add(createEmployee("4444"));
    }

    public static Employee createEmployee(String id){
        Employee employee = new Employee();
        employee.setAge(19);
        employee.setGender("Female");
        employee.setName("la");
        employee.setId(id);
        return employee;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public Employee getEmployeeById(String id) {
        return employeeList.stream().filter(x->x.getId().equals(id)).findFirst().get();
    }

    public Employee addNewEmployee(Employee employee) {
        employee.setId(UUID.randomUUID().toString());
        employeeList.add(employee);
        return employee;
    }

    public Employee deleteEmployee(String employeeId) {
        Employee employee = employeeList.stream().filter(x->x.getId().equals(employeeId)).findFirst().get();
        employeeList.remove(employee);
        return employee;
    }

    public Employee updateEmployee(Employee employee) {
        Employee employee1 = employeeList.stream().filter(x->x.getId().equals(employee.getId())).findFirst().get();
        employeeList.remove(employee1);
        employeeList.add(employee);
        return employee;
    }

    public List<Employee> outEmployeeSmallerThanAge(int age) {
        return employeeList.stream().filter(x->x.getAge()<age).collect(Collectors.toList());
    }
}

package com.example.springboot.service;

import com.example.springboot.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployee(int id);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
    List<Employee> getAllEmployeesByDepartment(Integer department);

}

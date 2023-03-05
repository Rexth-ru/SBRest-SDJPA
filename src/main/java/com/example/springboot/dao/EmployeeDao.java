package com.example.springboot.dao;

import com.example.springboot.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAllEmployees();
    Employee getEmployee(int id);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
}

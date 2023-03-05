package com.example.springboot.dao;

import com.example.springboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    List<Employee> findAllEmployeesByDepartment(Integer department);
}

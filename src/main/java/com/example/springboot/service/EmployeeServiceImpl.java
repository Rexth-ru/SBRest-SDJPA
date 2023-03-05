package com.example.springboot.service;

import com.example.springboot.dao.EmployeeRepo;
import com.example.springboot.entity.Employee;
import com.example.springboot.exception.EmployeeException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = employeeRepo.findById(id).get();
        if (employee == null){
            try {
                throw new EmployeeException("Employee with id: "+id+" does not exist");
            } catch (EmployeeException e) {
                throw new RuntimeException(e);
            }
        }
        return employee;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepo.save(employee);

    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepo.save(employee);

    }

    @Override
    public void deleteEmployee(int id) {
      employeeRepo.deleteById(id);
    }

    @Override
    public List<Employee> getAllEmployeesByDepartment(Integer department) {
        return employeeRepo.findAllEmployeesByDepartment(department);
    }
}

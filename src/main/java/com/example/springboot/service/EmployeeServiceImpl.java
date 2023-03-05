package com.example.springboot.service;

import com.example.springboot.dao.EmployeeDao;
import com.example.springboot.entity.Employee;
import com.example.springboot.exception.EmployeeException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        Employee employee = employeeDao.getEmployee(id);
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
    @Transactional
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);

    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);

    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        Employee employee = employeeDao.getEmployee(id);
        if (employee == null){
            try {
                throw new EmployeeException("Employee with id: "+id+" does not exist");
            } catch (EmployeeException e) {
                throw new RuntimeException(e);
            }
        }
        employeeDao.deleteEmployee(id);
    }
}

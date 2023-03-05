package com.example.springboot.controller;


import com.example.springboot.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import com.example.springboot.entity.Employee;
import java.util.List;

@RestController
@RequestMapping("/skypro")
public class RestControllerNew {
    private EmployeeService employeeService;

    public RestControllerNew(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/employee")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeService.getEmployee(id);
    }
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return employee;
    }
    @PutMapping("/employee")
    public  Employee updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
        return employee;
    }
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return "Employee with id: "+id+" was deleted";
    }
}

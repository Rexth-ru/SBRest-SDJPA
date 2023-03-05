package com.example.springboot.dao;

import com.example.springboot.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private EntityManager entityManager;

    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployees() {

        return entityManager.createQuery("from Employee").getResultList();
    }

    @Override
    public Employee getEmployee(int id) {
       return entityManager.find(Employee.class, id);
    }

    @Override
    public void addEmployee(Employee employee) {
       Employee newEmployee = entityManager.merge(employee);//чтобы получить новый объект с id
       employee.setId(newEmployee.getId());
    }

    @Override
    public void updateEmployee(Employee employee) {
       entityManager.merge(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        Query query = entityManager.createQuery("delete from Employee  where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();

    }
}




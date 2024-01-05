package com.paul.CrudJavaApp2.dao;

import com.paul.CrudJavaApp2.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    // define entity manager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;

    }
    @Override
    public List<Employee> findAll() {
        //create query
        TypedQuery<Employee> usersQuery = entityManager.createQuery("FROM Employee", Employee.class);

        //return results
        return usersQuery.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id) {
        Employee employee =  entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}

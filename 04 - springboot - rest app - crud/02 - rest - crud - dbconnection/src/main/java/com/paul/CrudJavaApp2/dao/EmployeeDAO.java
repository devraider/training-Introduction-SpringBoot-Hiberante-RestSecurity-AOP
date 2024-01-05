package com.paul.CrudJavaApp2.dao;

import com.paul.CrudJavaApp2.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);
    void deleteById(int id);
}

package com.paul.CrudJavaApp2.dao;

import com.paul.CrudJavaApp2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's no need to write any code
}

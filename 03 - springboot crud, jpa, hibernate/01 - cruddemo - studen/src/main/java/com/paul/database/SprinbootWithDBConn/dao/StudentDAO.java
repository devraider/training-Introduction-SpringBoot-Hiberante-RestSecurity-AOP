package com.paul.database.SprinbootWithDBConn.dao;

import com.paul.database.SprinbootWithDBConn.enity.Student;

import java.util.List;

public interface StudentDAO {


    void save(Student theStudent);

    void update(Student theStudent);

    void delete(Integer id);
    int deleteAll();

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String studentLastName);
}

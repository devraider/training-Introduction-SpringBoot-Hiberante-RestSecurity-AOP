package com.example.demo.dao;

import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetails;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int id);

    public InstructorDetails findInstructorDetailsById(int id);

    void deleteInstructorById(int id);

    void deleteInstructorDetailById(int id);
}

package com.example.demo.dao;

import com.example.demo.entity.Courses;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetails;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int id);

    public List<Courses> findCoursesByInstructorId(int id);
    public InstructorDetails findInstructorDetailsById(int id);

    public Instructor findInstructorByIdJoinCourses(int id);

    void deleteInstructorById(int id);

    void deleteInstructorDetailById(int id);

    void update(Instructor instructor);
    void update(Courses course);
    Courses findCourseById(int id);

    void save(Courses course);

    Courses findCourseAndReviewsById(int id);
}

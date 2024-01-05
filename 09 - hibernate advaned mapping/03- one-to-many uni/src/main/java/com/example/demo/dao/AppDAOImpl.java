package com.example.demo.dao;

import com.example.demo.entity.Courses;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

@Repository
public class AppDAOImpl implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public InstructorDetails findInstructorDetailsById(int id) {
        return entityManager.find(InstructorDetails.class, id);
    }

    @Override
    public List<Courses> findCoursesByInstructorId(int id) {
        TypedQuery<Courses> query = entityManager.createQuery(
                "FROM Courses where instructor.id=:data ORDER BY title ASC LIMIT 1", Courses.class
        );
        query.setParameter("data", id);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);

        List<Courses> courses = instructor.getCourses();

        for (Courses course: courses) {
            course.setInstructor(null);
        }

        entityManager.remove(instructor);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetails instructorDetails = entityManager.find(InstructorDetails.class, id);

        instructorDetails.getInstructor().setInstructorDetails(null);
        entityManager.remove(instructorDetails);
    }

    public Instructor findInstructorByIdJoinCourses(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "SELECT i FROM Instructor i " +
                        "JOIN FETCH   i.courses " +
                        "JOIN FETCH   i.instructorDetail " +
                        " WHERE i.id=:data",
                Instructor.class
        );
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Courses course) {
        entityManager.merge(course);
    }

    @Override
    @Transactional
    public void save(Courses course) {
        entityManager.persist(course);
    }

    @Override
    public Courses findCourseById(int id) {
        return entityManager.find(Courses.class, id);
    }

    @Override
    public Courses findCourseAndReviewsById(int id) {
        TypedQuery<Courses> q = entityManager.createQuery(
                "SELECT c FROM Courses c " +
                        "JOIN FETCH  c.reviews " +
                        "WHERE c.id = :id", Courses.class);

        q.setParameter("id", id);

        return q.getSingleResult();
    }
}

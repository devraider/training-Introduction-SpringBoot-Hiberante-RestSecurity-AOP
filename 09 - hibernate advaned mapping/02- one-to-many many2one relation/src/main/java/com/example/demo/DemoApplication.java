package com.example.demo;

import com.example.demo.dao.AppDAO;
import com.example.demo.entity.Courses;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			findInstructorDetails(appDAO);
//			deleteInstructor(appDAO);
//			deleteInstructorDetail(appDAO);
//			createInstructorWithCourses(appDAO);
//			findInstructorWithCourses(appDAO);
//			findCoursesForInstructor(appDAO);
//			findCoursesWithJoinFetch(appDAO);
//			updateInstructor(appDAO);
//			updateCourse(appDAO);
			deleteInstructor(appDAO);
		};
	}

	private void updateCourse(AppDAO appDAO) {
		int courseId = 10;

		Courses courses = appDAO.findCourseById(courseId);
		courses.setTitle("Marea Marmamar");

		appDAO.update(courses);
		System.out.println("Courses: " + courses);
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 1;

		Instructor instructor = appDAO.findInstructorById(id);

		instructor.setLastName("TESTERRR");

		appDAO.update(instructor);

		System.out.println(instructor);
	}

	private void findCoursesWithJoinFetch(AppDAO appDAO) {
		int id = 1;

		Instructor instructor = appDAO.findInstructorByIdJoinCourses(id);
		System.out.println("Instructor "+ instructor);
		System.out.println("Instructor courses "+ instructor.getCourses());

		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int id = 1;

		Instructor instructor = appDAO.findInstructorById(id);
		List<Courses> courses = appDAO.findCoursesByInstructorId(instructor.getId());


		// set courses
		instructor.setCourses(courses);
		System.out.println("Instructor "+ instructor);
		System.out.println("Instructor courses "+ instructor.getCourses());

		System.out.println("Done!");

	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Instructor "+ instructor);
		System.out.println("Instructor courses "+ instructor.getCourses());

		System.out.println("Done!");

	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor("Sara", "Dig", "adsa@gmail.com");

		InstructorDetails instructorDetails = new InstructorDetails("g.com", "Music");


		// associate instructor details to instructor objects
		instructor.setInstructorDetails(instructorDetails);

		System.out.println("Saving instructor: " + instructor);

		// adding courses
		Courses course1 = new Courses("Home Alone");
		Courses course2 = new Courses("pinball");
		instructor.add(course1);
		instructor.add(course2);

		System.out.println("Instructor: "+ instructor);
		System.out.println("Courses: "+ instructor.getCourses());
		System.out.println("course1: "+ course1);
		System.out.println("course2: "+ course2);

		appDAO.save(instructor);

	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 3;

		appDAO.deleteInstructorDetailById(id);
	}

	private void findInstructorDetails(AppDAO appDAO) {
		int id = 1;
		InstructorDetails instructorDetails = appDAO.findInstructorDetailsById(id);

		System.out.println("I details" + instructorDetails);
		System.out.println("I" + instructorDetails.getInstructor());
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 2;

		System.out.println(appDAO.findInstructorById(id));

	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;

		appDAO.deleteInstructorById(id);

	}

	private void createInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("Sara", "Dig", "adsa@gmail.com");

		InstructorDetails instructorDetails = new InstructorDetails("g.com", "Music");

		// associate instructor details to instructor objects
		instructor.setInstructorDetails(instructorDetails);

		System.out.println("Saving instructor: " + instructor);
		appDAO.save(instructor);
	}

}

package com.example.demo;

import com.example.demo.dao.AppDAO;
import com.example.demo.entity.*;
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
//			findCoursesAndReviews(appDAO);
//			createCourseAndStudentsa(appDAO);
//			findCourseAndStudents(appDAO);
//			findStudentAndCourses(appDAO);
//			addStudentsForCourses(appDAO);
			addDelStudent(appDAO);
//			addDelCourses(appDAO);
		};

	}

	private void addDelStudent(AppDAO appDAO) {


	}

	private void addStudentsForCourses(AppDAO appDAO) {
		int id = 1;
		Student s = appDAO.findStudentAndCourseByStudentId(id);

		s.addCourse(new Courses("GeorgyCloonyMasjk"));

		appDAO.update(s);
		System.out.println("s"+s);
		System.out.println("s"+s.getCourses());
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int id = 1;
		Student s = appDAO.findStudentAndCourseByStudentId(id);

		System.out.println("c"+s);
		System.out.println("s"+s.getCourses());
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int id = 10;
		Courses c = appDAO.findCourseAndStudentsByCourseId(id);


		System.out.println("c"+c);
		System.out.println("s"+c.getStudents());
	}

	private void createCourseAndStudentsa(AppDAO appDAO) {
		// create a course
		Courses course = new Courses("Salamnaca");

		// create students
		Student s1 = new Student("L", "E", "Sandra@d.c");
		Student s2 = new Student("Next", "E", "nxt@d.c");
		Student s3 = new Student("Col", "E", "col@d.c");

		//add students to course
		course.addStudent(s1);
		course.addStudent(s2);
		course.addStudent(s3);
		// save course and student
		appDAO.save(course);
//		System.out.println("c: "+course);
//		System.out.println("Std: "+course.getStudents());


	}

	private void findCoursesAndReviews(AppDAO appDAO) {
		int id = 10;

		Courses c = appDAO.findCourseAndReviewsById(id);

		System.out.println("C" + c);
		System.out.println("R" + c.getReviews());
	}

}

package com.paul.database.SprinbootWithDBConn;

import com.paul.database.SprinbootWithDBConn.dao.StudentDAO;
import com.paul.database.SprinbootWithDBConn.enity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SprinbootWithDbConnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprinbootWithDbConnApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return  runner -> {
//			createStudent(studentDAO);
			createMultipleStudent(studentDAO);

//			readStudent(studentDAO);

//			readAllStudents(studentDAO);

//			readStudentsByLastName(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);

//			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		int delRows = studentDAO.deleteAll();
		System.out.println("Deleted " + delRows + " rows");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		studentDAO.delete(studentId);

	}
	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student
		Student theStudent = studentDAO.findById(1);
		// change email address
		theStudent.setEmail("new_very@new.com");
		// update the student
		studentDAO.update(theStudent);
		// display updated
		System.out.println("Updated student " + theStudent);
	}

	private void readStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("basic");
		System.out.println(students);
	}

	private void readAllStudents(StudentDAO studentDAO) {
		List<Student> findAll = studentDAO.findAll();
		for (Student tempStudent : findAll) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create student object
		Student tempStudent = new Student("daffi", "duck", "etc@dd.com");
		// save the student object
		studentDAO.save(tempStudent);
		// display id
		int theId = tempStudent.getId();
		System.out.println("Id of inserted student " + theId);
		// retrieve student based on findById
		System.out.println("Retrieving student with give ID" + theId);
		Student retrivedStudent = studentDAO.findById(theId);

		// display student
		System.out.println("My student is " + retrivedStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating 3 new student");
		Student tempStudent1 = new Student("apple", "sanda", "setc@gmail.com");
		Student tempStudent2 = new Student("yanda", "grup", "betc@gmail.com");
		Student tempStudent3 = new Student("collen", "basic", "cetc@gmail.com");
		// save students objects
		System.out.println("Save all 3 students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
//		create student object
		System.out.println("Creating new student");
		Student tempStudent = new Student("paul", "Deo", "etc@gmail.com");

//		save the student
		System.out.println("Saving student");
		studentDAO.save(tempStudent);

//		display the id
		System.out.println("Saved student. With id "+ tempStudent.getId());
	}
}

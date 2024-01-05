package com.example.demo;

import com.example.demo.dao.AppDAO;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			deleteInstructorDetail(appDAO);
		};
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
		int id = 2;

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

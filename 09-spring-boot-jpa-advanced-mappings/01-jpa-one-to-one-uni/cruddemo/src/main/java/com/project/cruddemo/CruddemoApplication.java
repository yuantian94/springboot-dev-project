package com.project.cruddemo;

import com.project.cruddemo.dao.AppDAO;
import com.project.cruddemo.entity.Instructor;
import com.project.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Deleting instructor id: " + theId);

		appDAO.deleteInstructorById(theId);
		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("The associated instructorDetail only " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
//		// create the instructor
//
//		Instructor tempInstructor = new Instructor("Chad", "Darby","darby@gmail.com");
//
//		// create the instructor detail
//
//		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com/chaddarby","Luv to code");
//
//		// associate the objects
//		tempInstructor.setInstructorDetail(tempInstructorDetail);


		// create the instructor

		Instructor tempInstructor = new Instructor("Yuan", "Tian","yuantian@gmail.com");

		// create the instructor detail

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com/yuantian","Luv to bike");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		//
		// NOTE: this will ALSO save the details object, because of CascadeType.ALL
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");

	}



}

package com.example.springboot.hibernatejpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.springboot.hibernatejpa.DAO.AppDAO;
import com.example.springboot.hibernatejpa.entity.Instructor;
import com.example.springboot.hibernatejpa.entity.InstructorDetail;

@SpringBootApplication
public class HibernateJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaApplication.class, args);
	}
    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
            return runner->{
            	//createInstructor(appDAO);
            	//findInstructor(appDAO);
            	deleteInstructor(appDAO);
            };
    }
	private void deleteInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
           appDAO.deleteInstructorById(2);
	}
	private void findInstructor(AppDAO appDAO ) {
		// TODO Auto-generated method stub
	   Instructor instructor = appDAO.findInstructorById(2);
	   System.out.println(instructor);
	}
	private void createInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		Instructor instructor = new Instructor(
				"ramya","karanam","ramya123@gmail.com"
				);
		InstructorDetail instructorDetail =
				 new InstructorDetail("https://github.com/karanara","practice");
		instructor.setInstructorDetail(instructorDetail);
		
		appDAO.save(instructor);
		/*Instructor tempInstructor =
				new Instructor("Madhu", "Patel", "madhu@luv2code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.luv2code.com/youtube",
						"Guitar");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		//
		// NOTE: this will ALSO save the details object
		// because of CascadeType.ALL
		//
		//System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);*/

		//System.out.println("Done!");
	}
}

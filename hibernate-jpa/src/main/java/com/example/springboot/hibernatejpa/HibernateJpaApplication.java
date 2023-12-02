package com.example.springboot.hibernatejpa;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.springboot.hibernatejpa.DAO.AppDAO;
import com.example.springboot.hibernatejpa.entity.Course;
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
            	//deleteInstructor(appDAO);
            	//findInstructorDetailById(appDAO);
            	//deleteInstructorByInstructionId(appDAO);
            	//createInstructorWithCourses(appDAO);
            	//findCoursesForInstructor(appDAO);
            	//findCoursesForInstructorByJoinFetch(appDAO);
            	//updateInstructor(appDAO);
            	//updateCourse(appDAO);
            	deleteCourse(appDAO);
            };
    }
	private void deleteCourse(AppDAO appDAO) {
		// TODO Auto-generated method stub
		appDAO.deleteCourse(10);
		
	}
	private void updateCourse(AppDAO appDAO) {
		// TODO Auto-generated method stub
		Course course = appDAO.getCourseById(10);
		System.out.println(course);
		course.setTitle("Spring Boot by luv darby");
		appDAO.updateCourse(course);
		
	}
	private void updateInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		Instructor instructor = appDAO.findInstructorById(1);
		instructor.setLast_name("Srinivas");
		appDAO.updateInstructor(instructor);
		
	}
	private void findCoursesForInstructorByJoinFetch(AppDAO appDAO) {
		// TODO Auto-generated method stub
		Instructor instructor =appDAO.findInstructorByJoinFetch(1);
		System.out.println("Instructor Details  "+instructor);
		System.out.println("InstructorDetail of instructor  "+ instructor.getInstructorDetail());
		System.out.println("Instructor Courses  "+ instructor.getCourses());
		
	}
	private void findCoursesForInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		   Instructor instructor = appDAO.findInstructorById(1);
		   System.out.println("Finding Instructor  "+ instructor);
           List<Course> courses= appDAO.findCoursesForInstructor(1);
           instructor.setCourses(courses);
           System.out.println("COurses for Instructor:  " + instructor.getCourses());
	}
	private void createInstructorWithCourses(AppDAO appDAO) {
		// TODO Auto-generated method stub
		Instructor instructor = new Instructor(
				"ramya","karanam","ramya123@gmail.com"
				);
		InstructorDetail instructorDetail =
				 new InstructorDetail("https://github.com/karanara","practice");
		instructor.setInstructorDetail(instructorDetail);
		Course course1= new Course("JAVA");
		Course course2= new Course("Python");
		instructor.add(course1);
		instructor.add(course2);
		appDAO.save(instructor);
		
	}
	private void deleteInstructorByInstructionId(AppDAO appDAO) {
		// TODO Auto-generated method stub
		//InstructorDetail instructorDetail = appDAO.findInstructorDetailById(3);
        //instructorDetail.setInstructor(null);
        appDAO.deleteInstructorDetailById(3);
	}
	private void findInstructorDetailById(AppDAO appDAO) {
		// TODO Auto-generated method stub
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(3);
		System.out.println(instructorDetail);
		System.out.println(instructorDetail.getInstructor());
	}
	private void deleteInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
           appDAO.deleteInstructorById(1);
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

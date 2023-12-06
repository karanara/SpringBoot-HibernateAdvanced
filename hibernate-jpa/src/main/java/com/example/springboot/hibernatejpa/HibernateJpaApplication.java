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
import com.example.springboot.hibernatejpa.entity.Review;
import com.example.springboot.hibernatejpa.entity.Student;

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
            	//deleteCourse(appDAO);
            	//CreateCourseWithReviews(appDAO);
            	//findCourseandReviews(appDAO);
            	//deleteCourseWithReviews(appDAO);
            	// createCourseAndStudents(appDAO);

    			// findCourseAndStudents(appDAO);

    			// findStudentAndCourses(appDAO);

    			// addMoreCoursesForStudent(appDAO);

    			// deleteCourse(appDAO);

    			//deleteStudent(appDAO);
            };
    }
    

	private void deleteStudent(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Deleting student id: " + theId);

		appDAO.deleteStudentById(theId);

		System.out.println("Done!");
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {

		int theId = 2;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		// create more courses
		Course tempCourse1 = new Course("Rubik's Cube - How to Speed Cube");
		Course tempCourse2 = new Course("Atari 2600 - Game Development");

		// add courses to student
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);

		System.out.println("Updating student: " + tempStudent);
		System.out.println("associated courses: " + tempStudent.getCourses());

		appDAO.update(tempStudent);

		System.out.println("Done!");
	}

	private void findStudentAndCourses(AppDAO appDAO) {

		int theId = 2;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		System.out.println("Loaded student: " + tempStudent);
		System.out.println("Courses: " + tempStudent.getCourses());

		System.out.println("Done!");
	}

	private void findCourseAndStudents(AppDAO appDAO) {

		int theId = 10;
		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);

		System.out.println("Loaded course: " + tempCourse);
		System.out.println("Students: " + tempCourse.getStudents());

		System.out.println("Done!");
	}

	private void createCourseAndStudents(AppDAO appDAO) {

		// create a course
		Course tempCourse = new Course("Pacman - How To Score One Million Points");

		// create the students
		Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");

		// add students to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		// save the course and associated students
		System.out.println("Saving the course: " + tempCourse);
		System.out.println("associated students: " + tempCourse.getStudents());

		appDAO.updateCourse(tempCourse);

		System.out.println("Done!");
	}
	private void deleteCourseWithReviews(AppDAO appDAO) {
		// TODO Auto-generated method stub
		appDAO.deleteCourseWithReviewByCourseId(12);
		//delete reveiws since it is unidirectional and cascade.all
	}
	private void findCourseandReviews(AppDAO appDAO) {
		// TODO Auto-generated method stub
		Course course = appDAO.findCourseWithReviewsByCourseId(12);
		System.out.println(course);
		System.out.println(course.getReviews());
	}
	private void CreateCourseWithReviews(AppDAO appDAO) {
		// TODO Auto-generated method stub
		Course course = new Course("JAVA with Spring");
		course.addReview(new Review("ccovered all concepts with complete examples"));
		course.addReview(new Review("need more concepts"));
		course.addReview(new Review("expecting more releases"));
		appDAO.saveCourseWithReviews(course);
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

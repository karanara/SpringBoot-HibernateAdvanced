package com.example.springboot.hibernatejpa.DAO;

import com.example.springboot.hibernatejpa.entity.Instructor;
import com.example.springboot.hibernatejpa.entity.InstructorDetail;
import com.example.springboot.hibernatejpa.entity.Student;

import java.util.List;

import com.example.springboot.hibernatejpa.entity.Course;
public interface AppDAO {

	void save (Instructor instructor);
	Instructor findInstructorById(int Id);
	void deleteInstructorById(int Id);
	//bidirectional
	InstructorDetail findInstructorDetailById(int Id);
	//delete only InstructorDetail not instructor 
	void deleteInstructorDetailById(int Id);
	List<Course> findCoursesForInstructor(int Id);
	//join fetch 
	Instructor findInstructorByJoinFetch(int Id);
	//Update Instructor
	void updateInstructor(Instructor  instructor);
	//update course
	void updateCourse(Course course);
	//get course by id
	Course getCourseById(int Id);
	 //delete course 
	 void deleteCourse(int Id);
	//creating courses with reviews
	 void saveCourseWithReviews(Course course);
	 //retreiving courses with reviews
	 Course findCourseWithReviewsByCourseId(int Id);
	 //deleting courses with reviews since unidirectional
	 void deleteCourseWithReviewByCourseId(int Id);
	 Course findCourseAndStudentsByCourseId(int theId);

	    Student findStudentAndCoursesByStudentId(int theId);

	    void update(Student tempStudent);

	    void deleteStudentById(int theId);
} 

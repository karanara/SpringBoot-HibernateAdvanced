package com.example.springboot.hibernatejpa.DAO;

import com.example.springboot.hibernatejpa.entity.Instructor;
import com.example.springboot.hibernatejpa.entity.InstructorDetail;

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
}

package com.example.springboot.hibernatejpa.DAO;

import com.example.springboot.hibernatejpa.entity.Instructor;

public interface AppDAO {

	void save (Instructor instructor);
	Instructor findInstructorById(int Id);
	void deleteInstructorById(int Id);
	
}

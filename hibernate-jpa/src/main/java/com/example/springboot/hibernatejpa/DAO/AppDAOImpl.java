package com.example.springboot.hibernatejpa.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springboot.hibernatejpa.entity.Instructor;
import com.example.springboot.hibernatejpa.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {

	private EntityManager entityManager;
	
	@Autowired
	public AppDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	} 
	@Override
	@Transactional
	public void save(Instructor instructor) {
		// TODO Auto-generated method stub
		entityManager.persist(instructor);
	}

	

	@Override
	public Instructor findInstructorById(int Id) {
		// TODO Auto-generated method stub
		Instructor theInstructor = entityManager.find(Instructor.class,Id);
		return theInstructor;
	}

	@Override
	@Transactional
	public void deleteInstructorById(int Id) {
		// TODO Auto-generated method stub
		Instructor theInstructor = entityManager.find(Instructor.class,Id);
        entityManager.remove(theInstructor);

	}
	@Override
	public InstructorDetail findInstructorDetailById(int Id) {
		// TODO Auto-generated method stub
		InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, Id);
		return instructorDetail;
	}
	@Override
	@Transactional
	public void deleteInstructorDetailById(int Id) {
		// TODO Auto-generated method stub
		InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, Id);
		instructorDetail.getInstructor().setInstructorDetail(null);
		entityManager.remove(instructorDetail);
	}

}

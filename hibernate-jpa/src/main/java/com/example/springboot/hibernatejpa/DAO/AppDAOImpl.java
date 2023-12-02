package com.example.springboot.hibernatejpa.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springboot.hibernatejpa.entity.Course;
import com.example.springboot.hibernatejpa.entity.Instructor;
import com.example.springboot.hibernatejpa.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
		//to prevent constraint voilation since havign one to many relationship
		List<Course> courses = theInstructor.getCourses();
		for(Course temp :courses) {
			temp.setInstructor(null);
		}
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
		//break bi directional break
		instructorDetail.getInstructor().setInstructorDetail(null);
		entityManager.remove(instructorDetail);
	}
	@Override
	public List<Course> findCoursesForInstructor(int Id) {
		// TODO Auto-generated method stub
		TypedQuery<Course> query= entityManager.createQuery("from Course where instructor.id=:data",Course.class);
		query.setParameter("data", Id);
		List<Course> courses = query.getResultList();
		return courses;
	}
	@Override
	public Instructor findInstructorByJoinFetch(int Id) {
		// TODO Auto-generated method stub
		TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i "+ "JOIN FETCH i.courses " +
		"JOIN FETCH i.instructorDetail " + "where i.id=:data", Instructor.class);
		query.setParameter("data", Id);
		return query.getSingleResult();
	}
	@Override
	@Transactional
	public void updateInstructor(Instructor instructor) {
		// TODO Auto-generated method stub
		entityManager.merge(instructor);
	}
	@Override
	@Transactional
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		entityManager.merge(course);
		
	}
	@Override
	public Course getCourseById(int Id) {
		// TODO Auto-generated method stub
		Course course = entityManager.find(Course.class, Id);
		return course;
	}
	
	@Override
	@Transactional
	public void deleteCourse(int Id) {
		// TODO Auto-generated method stub
		Course course = entityManager.find(Course.class,Id);
		entityManager.remove(course);
	}
	@Override
	@Transactional
	public void saveCourseWithReviews(Course course) {
		// TODO Auto-generated method stub
        entityManager.persist(course);		
	}
	@Override
	public Course findCourseWithReviewsByCourseId(int Id) {
		// TODO Auto-generated method stub
		TypedQuery<Course> query = entityManager.createQuery("select c from Course c "+ "JOIN FETCH c.reviews " +
		"where c.id=:data" , Course.class);
		query.setParameter("data", Id);
		
		return query.getSingleResult(); 
	}
	@Override
	@Transactional
	public void deleteCourseWithReviewByCourseId(int Id) {
		// TODO Auto-generated method stub
		Course course = entityManager.find(Course.class,Id);
		entityManager.remove(course);
		
	}
	

}

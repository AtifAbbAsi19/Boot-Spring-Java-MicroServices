package io.database.course.api.courseapidatabase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.database.course.api.courseapidatabase.model.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
	
	
	public List<Course> findByTopicId(Integer topicId);
	

	public List<Course> findByTopicTopicTitle(String topicTitle);
	

}




/*
 * @Repository public interface CourseRepositorys extends JpaRepository<Course,
 * Integer> {
 * 
 * 
 * public List<Course> findByTopicId(Integer topicId);
 * 
 * 
 * public List<Course> findByTopicTopicTitle(String topicTitle);
 * 
 * 
 * }
 */





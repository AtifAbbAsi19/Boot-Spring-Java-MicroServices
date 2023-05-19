package io.database.course.api.courseapidatabase.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import io.database.course.api.courseapidatabase.model.BaseResponse;
import io.database.course.api.courseapidatabase.model.Course;
import io.database.course.api.courseapidatabase.repository.CourseRepository;

@Service
public class CourseService {


	@Autowired
	public CourseRepository courseRepository;
	
	
	public List<Course> getAllCourseByTopic(Integer topicId) {
		
		List<Course> courses = new ArrayList<>();
		 courseRepository.findByTopicId(topicId).forEach(courses::add);
		 
		 
		 
		// BaseResponse<Course> response = new  BaseResponse<>();
		 
		 //Course course = new Course();
		// response.setData(course);
		
		 
		 return courses;
		 
	}
	
	
	

	
	/*
	 * { "statusCode": 200, 
	 * "successmessage": "Successfull",
	 *  "data": {},
	 * "errorMessage": null 
	 * }
	 */
	
	
	
	public List<Course> getAllCourseByTopicTitle(String topicTitle) {
		
		List<Course> courses = new ArrayList<>();
		 courseRepository.findByTopicTopicTitle(topicTitle).forEach(courses::add);
		 return courses;
		 
	}
	
	
	public List<Course> getAllCourse() {
		
		List<Course> courses = new ArrayList<>();
		 courseRepository.findAll().forEach(courses::add);
		 return courses;
		 
	}
	
	
	public void addCourse(Course course) {
		System.out.print(course.toString());
		courseRepository.save(course);
	}
	
	

	public void updateCourse(Integer id,Course course) {
		courseRepository.save(course);
	}
	
	public Course getCourse(Integer id) {

		return courseRepository.findById(id).get();
	
	}
	
	
	public void deleteCourse(Integer id) {

		courseRepository.deleteById(id);
	}
	

}

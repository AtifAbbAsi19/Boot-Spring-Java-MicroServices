package io.database.course.api.courseapidatabase.controller;

import java.awt.print.Printable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import org.hibernate.grammars.ordering.OrderingParser.CollationSpecificationContext;
import org.hibernate.mapping.Collection;
import org.hibernate.sql.ast.tree.expression.Collation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import io.database.course.api.courseapidatabase.model.Course;
import io.database.course.api.courseapidatabase.model.Topic;
import io.database.course.api.courseapidatabase.network.MyErrorHandler;
import io.database.course.api.courseapidatabase.response.TopicListResponse;
import io.database.course.api.courseapidatabase.response.TopicResponse;
import io.database.course.api.courseapidatabase.response.TopicsResponse;
import io.database.course.api.courseapidatabase.service.CourseService;

@RestController
public class CourseController {
	
	
	
	
	private Logger logger = (Logger) LoggerFactory.getLogger(CourseController.class);
	
	
	@Autowired
	private CourseService courseService;
	
	

	@Autowired
	private RestTemplate restTemplate;
	
	
	
	@GetMapping(value = "/topics/{id}/courses")
	public  List<Course> getAllCourse(@PathVariable("id") Integer id) {
		//return courseService.getAllCourse();
		return courseService.getAllCourseByTopic(id);
		
	}
	
	
	
	

	
	
	
	@GetMapping(value = "/topicsdetails")
	ResponseEntity<TopicsResponse> customHeader() {
	   
		

	   
		 restTemplate.setErrorHandler(new MyErrorHandler());
			
		 HttpHeaders headers = new HttpHeaders();
		 headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	     
		 HttpEntity <String> entity = new HttpEntity<String>(headers);
		 
		 String url =  "http://localhost:8081/topics";
		 
		 
	    //  HttpEntity<Topic> entity = new HttpEntity<Topic>(topic,headers);
	
		 
	    try{
	    
	    	String tempResponse =  restTemplate.
	    			 exchange(
	    			 url,
	    			 HttpMethod.GET,
	    			 entity,
	    			 String.class).
	    			 getBody();
	    	
	    	
	    	
	    	
	    	
	    	
	    	Gson gson = new Gson();
	    	
	    	Type typeList = new TypeToken<ArrayList<TopicResponse>>(){}.getType();
	    	
	    	List<TopicResponse> topics = gson.fromJson(tempResponse,typeList);
	
	    	TopicListResponse listResponse = new TopicListResponse();
	    	listResponse.setTopics(topics);
	    	listResponse.setCount(topics.size());
	    	listResponse.setDate("17/01/2023");
	    	
	    	
	    	TopicsResponse response = new TopicsResponse();
	    	
	    	
	    	response.setData(listResponse);
	    	//listResponse.setData((ArrayList<TopicResponse>) topics);
	    	response.setStatusCode(200);
	      	response.setResponseCode("200XBC");
	    	response.setMessage("Request Successfull");
	    	
	
	    	
	    	
	    	System.out.println("Logs:Topics::" + response.toString());
	    	 
	    	
	    	//System.out.println("Logs:" + tempResponse.toString());
	    	 
	    	 
	    	 
	    	 return new ResponseEntity<TopicsResponse>(
	    			 response,
	    			 headers,
	    			 HttpStatus.OK
	    			 );
	    	
	    	//  Object response =   restTemplate.exchange("",Object.class);
	    	 
	    	 
	    	 
	   } catch(HttpStatusCodeException e){
	        String errorPayLoad = e.getResponseBodyAsString();
	       
	        //400 500 200 404 401 
	    	TopicsResponse response = new TopicsResponse();
	        
	        return new ResponseEntity<TopicsResponse>(
	    			 response,
	    			 headers,
	    			 HttpStatus.METHOD_FAILURE
	    			 );
	        
	        
	   } catch(RestClientException e){
		   
		   //Unable to reach , or network issue , certificate issue
		   
		     //no response pay Load,
					System.out.println("Logs:" + e.getMessage().toString());
		   
		   TopicsResponse response = new TopicsResponse();
	        
	        return new ResponseEntity<TopicsResponse>(
	    			 response,
	    			 headers,
	    			 HttpStatus.METHOD_FAILURE
	    			 );
		   
	   
	    	 
	   }
	     
	 //   return  ResponseEntity.ok(null);
	
	    
		/*
		 * return new ResponseEntity<TopicResponse>( null , headers, HttpStatus.OK);
		 */
	}
	
	
	
	@GetMapping(value = "/topics/{title}/courses")
	public  List<Course> getAllCourseByTopicTitle(@PathVariable("title") String title) {
		//return courseService.getAllCourse();
		return courseService.getAllCourseByTopicTitle(title);
		
	}
	
	
	@RequestMapping(method = RequestMethod.GET  ,value = "/topics/{id}/courses/{courseId}")
	public  Course getCourse(@PathVariable("id") Integer id) {
		return courseService.getCourse(id);
	}
	
	
	
	
	@RequestMapping(method = RequestMethod.POST  ,value = "topics/{id}/courses")
	public void addCourse(@RequestBody Course course , @PathVariable("id") Integer topicId) {
		course.setTopic(new Topic(topicId, null, null));
		courseService.addCourse(course);
	}
	

	
	  @RequestMapping(method = RequestMethod.POST ,value = "/addCourse") public
	  void addCourxe(@RequestBody Course course) { courseService.addCourse(course);
	  }
	
	


	@RequestMapping(method = RequestMethod.PUT  ,value = "topics/{topicId}/courses/{courseId}")
	public void updateCourse(
			@RequestBody Course course, 
			@PathVariable("topicId") Integer topicId ,
			@PathVariable("courseId") Integer id) {
		course.setTopic(new Topic(topicId, null, null));
		courseService.updateCourse(id , course);
	}
	
	

	@RequestMapping(method = RequestMethod.DELETE  ,value = "topics/{topicId}/courses/{courseId}")
	public void deleteCourse(@PathVariable("courseId")Integer id) { 
		courseService.deleteCourse(id);
	}
	
	
	

}

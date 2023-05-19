package io.database.course.api.courseapidatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CourseApiDatabaseApplication {

	
	
	@Bean
	public RestTemplate getRestTemplate (){
		return  new RestTemplate();
	}
	
	
	
	/*
	 * @Bean public Logger getLogger() { return (Logger)
	 * LoggerFactory.getILoggerFactory(); }
	 */
	
	//private Logger logger = (Logger) LoggerFactory.getILoggerFactory();
	
	

	public static void main(String[] args) {
		SpringApplication.run(CourseApiDatabaseApplication.class, args);
	}

}

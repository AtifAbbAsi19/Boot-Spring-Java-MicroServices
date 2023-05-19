package io.database.course.api.courseapidatabase.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.database.course.api.courseapidatabase.model.Topic;
import io.database.course.api.courseapidatabase.repository.TopicRepositiory;

@Service
public class TopicService {
	
	
	
	@Autowired
	private TopicRepositiory topicRepositiory;
	
	
	
	public void addTopic(Topic topic) {
		System.out.println(topic.toString());
		topicRepositiory.save(topic);
	}
	
	

	public void updateTopic(Topic topic) {
		topicRepositiory.save(topic);
	}
	

	
	public void deleteTopic(Integer topicId) {
		topicRepositiory.deleteById(topicId);
	}
	
	public Topic getTopic(Integer topicId) {
		return topicRepositiory.findById(topicId).get();
	}
	
	
	public List<Topic> getAllTopics() {
		
		ArrayList<Topic> topics = new ArrayList<>();
		
		topicRepositiory.findAll().forEach(topics::add);
		return topics;
	}
	

}

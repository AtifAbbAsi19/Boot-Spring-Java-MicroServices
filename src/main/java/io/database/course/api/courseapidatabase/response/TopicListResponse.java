package io.database.course.api.courseapidatabase.response;

import java.util.ArrayList;
import java.util.List;

import io.database.course.api.courseapidatabase.model.BaseResponse;

public class TopicListResponse  {

	List<TopicResponse> topics;
	

	String date ="17/01/2023";
	Integer count = 10;
	

	public List<TopicResponse> getTopics() {
		return topics;
	}

	public void setTopics(List<TopicResponse> topics) {
		this.topics = topics;
	}




	public void setDate(String date) {
		this.date = date;
	}


	public Integer getCount() {
		return count;
	}


	public void setCount(Integer count) {
		this.count = count;
	}

	
	
	public String getDate() {
		return date;
	}



	
	
	public TopicListResponse(List<TopicResponse> topics, String date, Integer count) {
		super();
		this.topics = topics;
		this.date = date;
		this.count = count;
	}

	public TopicListResponse() {
		super();
		
	}
	
	
}

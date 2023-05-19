package io.database.course.api.courseapidatabase.response;

import io.database.course.api.courseapidatabase.model.BaseResponse;

public class TopicResponse {

	
	
	private Integer id;
	private Integer topicId;
	private String topicTitle;
	private String topicDiscription;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	public String getTopicTitle() {
		return topicTitle;
	}
	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}
	public String getTopicDiscription() {
		return topicDiscription;
	}
	public void setTopicDiscription(String topicDiscription) {
		this.topicDiscription = topicDiscription;
	}
	
	
	
	public TopicResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
}

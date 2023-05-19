package io.database.course.api.courseapidatabase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Topic {

	@Id 
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer topicId;
	private String topicTitle;
	private String topicDiscription;
	
	
	public Topic() {
	}
	

	public Topic(Integer id, String topicTitle, String topicDiscription) {
		super();
		this.id = id;
		this.topicId = id;
		this.topicTitle = topicTitle;
		this.topicDiscription = topicDiscription;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTopicId() {
		return id;
	}

	public void setTopicId() {
		this.topicId = this.id;
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

	@Override
	public String toString() {
		return "Topic [topicId=" + id + ", topicTitle=" + topicTitle + ", topicDiscription=" + topicDiscription
				+ ", getTopicId()=" + getTopicId() + ", getTopicTitle()=" + getTopicTitle() + ", getTopicDiscription()="
				+ getTopicDiscription() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	
}

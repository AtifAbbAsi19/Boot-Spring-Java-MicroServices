package io.database.course.api.courseapidatabase.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.database.course.api.courseapidatabase.model.Course;
import io.database.course.api.courseapidatabase.model.Topic;


@Repository
public interface TopicRepositiory extends CrudRepository<Topic, Integer> {

}
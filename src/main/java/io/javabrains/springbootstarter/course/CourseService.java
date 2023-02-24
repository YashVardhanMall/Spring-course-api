package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId){
		//return topics;
		List<Course> topics = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(topics::add);
		return topics;
	}
	
	public Course getCourse(String id) {
		//return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		Course t =  courseRepository.findById(id).get();
		return t;
		
	}

	public void addCourse(Course course) {
		//topics.add(topic);
		courseRepository.save(course);
	}

	public void updateCourse(Course topic) {
		// TODO Auto-generated method stub
		/*
		 * for(int i=0;i<topics.size();i++) { Topic t = topics.get(i);
		 * if(t.getId().equals(id)) { topics.set(i, topic); return; } }
		 */
		
		courseRepository.save(topic);
	}

	public void deleteCourse(String id) {
		//topics.removeIf(t->t.getId().equals(id));
		courseRepository.deleteById(id);
		
	}
}

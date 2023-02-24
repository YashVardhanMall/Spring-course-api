package io.javabrains.springbootstarter.course;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topic/{id}/courses")//default is get so no need to define method for GET
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("/topic/{topidId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topic/{topidId}/courses")
	public void addTopic(@RequestBody Course course, @PathVariable String topicId) {
		
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topic/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topic/{topicId}/course/{id}")
	public void deleteTopic(@PathVariable String id) {
		courseService.deleteCourse(id);
	}

}

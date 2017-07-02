package com.lq.test.ch3.mapper;

import java.util.List;
import java.util.Map;

import com.lq.test.ch3.domain.Course;

public interface CourseMapper
{

	List<Course> selectCoursesByTutor(int tutorId);

	List<Course> searchCourses(Map<String, Object> map);

	List<Course> searchCoursesByTutors(Map<String, Object> map);

}

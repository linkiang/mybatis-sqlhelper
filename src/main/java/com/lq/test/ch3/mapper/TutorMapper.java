package com.lq.test.ch3.mapper;

import com.lq.test.ch3.domain.Tutor;

public interface TutorMapper
{

	Tutor selectTutorWithCourses(int tutorId);
	
	Tutor selectTutorById(int tutorId);
	
}

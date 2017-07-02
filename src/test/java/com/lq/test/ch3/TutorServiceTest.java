package com.lq.test.ch3;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.lq.test.ch3.domain.Course;
import com.lq.test.ch3.domain.Tutor;
import com.lq.test.ch3.service.TutorService;

public class TutorServiceTest 
{
	private static TutorService tutorService;
	
	@BeforeClass
	public static void setup()
	{
		//TestDataPopulator.initDatabase();
		tutorService = new TutorService();
	}
	
	@AfterClass
	public static void teardown()
	{
		tutorService = null;
	}
	
	
	@Test
	public void testFindTutorById() {
		Tutor tutor = tutorService.findTutorById(1);
		Assert.assertNotNull(tutor);
		List<Course> courses = tutor.getCourses();
		Assert.assertNotNull(courses);
		for (Course course : courses) 
		{
			Assert.assertNotNull(course);
			System.out.println(course);
		}
	}
	
	@Test
	public void testFindTutorByIdSelect() {
		Tutor tutor = tutorService.findTutorByIdSelect(1);
		Assert.assertNotNull(tutor);
		List<Course> courses = tutor.getCourses();
		Assert.assertNotNull(courses);
		for (Course course : courses) 
		{
			Assert.assertNotNull(course);
			System.out.println(course);
		}
	}
	
	
}

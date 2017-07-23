package com.lq.test.ch3;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.lq.test.ch3.domain.Course;
import com.lq.test.ch3.service.CourseService;
import com.lq.test.ch3.util.MyBatisUtil;
import com.lq.test.ch3.util.SqlHelper;

public class CourseServiceTest 
{
	private static CourseService courseService;
	
	@BeforeClass
	public static void setup()
	{
		//TestDataPopulator.initDatabase();
		courseService = new CourseService();
	}
	
	@AfterClass
	public static void teardown()
	{
		courseService = null;
	}
	
	@Test
	public void searchCourses() 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutorId", 1);
		//map.put("courseName", "%java%");
		map.put("startDate", new Date());
		List<Course> courses = courseService.searchCourses(map);
		Assert.assertNotNull(courses);
		for (Course course : courses) {
			Assert.assertNotNull(course);
			//System.out.println(course);
		}
	}
	
	@Test
	public void searchCoursesByTutors() 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<Integer> tutorIds = new ArrayList<Integer>();
		tutorIds.add(1);
		tutorIds.add(2);
		map.put("tutorIds", tutorIds);
		map.put("courseName", "%Java%");
		//map.put("end", new Date());
		List<Course> courses = courseService.searchCoursesByTutors(map);
		Assert.assertNotNull(courses);
		for (Course course : courses) {
			Assert.assertNotNull(course);
			System.out.println(course);
		}
	}
	
	@Test
	public void testSqlHelper()
	{
		SqlSessionFactory sessionFactory = MyBatisUtil.getSqlSessionFactory();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("courseName", "abc");
		String sql = SqlHelper.getNamespaceSql1(sessionFactory.getConfiguration(), "com.lq.test.ch3.mapper.CourseMapper.searchCourses", map);
		System.out.println(sql);
		
		List<String> tutorIds = new ArrayList<String>();
//		tutorIds.add("11");
		map.put("tutorIds", tutorIds);
		//map.put("aa", "hello");
		
		sql = SqlHelper.getNamespaceSql1(sessionFactory.getConfiguration(), "com.lq.test.ch3.mapper.CourseMapper.searchCoursesByTutors", map);
		System.out.println(sql);
		
	}
}
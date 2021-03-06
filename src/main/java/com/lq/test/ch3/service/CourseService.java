package com.lq.test.ch3.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lq.test.ch3.domain.Course;
import com.lq.test.ch3.mapper.CourseMapper;
import com.lq.test.ch3.util.MyBatisUtil;

public class CourseService 
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public List<Course> searchCourses(Map<String, Object> map) 
	{
		logger.debug("searchCourses By :"+map);
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
			return mapper.searchCourses(map);
		} 
		
		finally {
			sqlSession.close();
		}
	}

	public List<Course> searchCoursesByTutors(Map<String, Object> map) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
			return mapper.searchCoursesByTutors(map);
		} 
		
		finally {
			sqlSession.close();
		}
	}
}
package com.lq.test.ch3.service;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lq.test.ch3.domain.Tutor;
import com.lq.test.ch3.mapper.TutorMapper;
import com.lq.test.ch3.util.MyBatisUtil;

public class TutorService 
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	public Tutor findTutorById(int tutorId) {
		logger.debug("findTutorById :"+tutorId);
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			TutorMapper mapper = sqlSession.getMapper(TutorMapper.class);
			return mapper.selectTutorById(tutorId);
		} 
		
		finally {
			sqlSession.close();
		}
	}
	

	public Tutor findTutorByIdSelect(int tutorId) {
		logger.debug("findTutorById :"+tutorId);
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			TutorMapper mapper = sqlSession.getMapper(TutorMapper.class);
			return mapper.selectTutorWithCourses(tutorId);
		} 
		
		finally {
			sqlSession.close();
		}
	}

	
}
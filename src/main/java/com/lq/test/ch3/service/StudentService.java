package com.lq.test.ch3.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.lq.test.ch3.domain.Student;
import com.lq.test.ch3.mapper.StudentMapper;
import com.lq.test.ch3.util.MyBatisUtil;

public class StudentService 
{
	
	public List<Student> findAllStudents()
	{
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findAllStudents();
		} finally {
			sqlSession.close();
		}
	}
	
	public Student findStudentById(Integer id)
	{
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findStudentById(id);
		} finally {
			sqlSession.close();
		}
	}

	public Student findStudentWithAddressById(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.selectStudentWithAddress(id);
		} finally {
			sqlSession.close();
		}
	}
	
	public Student createStudent(Student student) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			mapper.insertStudent(student);
			sqlSession.commit();
			return student;
		} 
		catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}
		finally {
			sqlSession.close();
		}
	}
	
	public void createStudentWithMap(Map<String, Object> studentDataMap) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			mapper.insertStudentWithMap(studentDataMap);
			sqlSession.commit();
		} 
		catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}
		finally {
			sqlSession.close();
		}
	}

	public Student updateStudent(Student student) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			int a = mapper.updateStudent(student);
			System.out.println("a="+ a);
			sqlSession.commit();
			return student;
		} 
		catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}
		finally {
			sqlSession.close();
		}
	}
	
	public boolean deleteStudent(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			int count = mapper.deleteStudent(id);
			sqlSession.commit();
			return count > 0;
		} 
		catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}
		finally {
			sqlSession.close();
		}
	}
	
}
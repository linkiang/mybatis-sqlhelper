package com.lq.test.ch3.mapper;

import java.util.List;
import java.util.Map;

import com.lq.test.ch3.domain.Student;

public interface StudentMapper
{

	List<Student> findAllStudents();

	Student findStudentById(Integer id);

	Student selectStudentWithAddress(int id);
	
	void insertStudent(Student student);
	
	void insertStudentWithMap(Map<String, Object> map);

	int updateStudent(Student student);
	
	int deleteStudent(int id);
	
}
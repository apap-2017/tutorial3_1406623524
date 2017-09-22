package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Student;

public interface StudentService {
//	Student selectStudent(Optional<String> npm);

	List<Student> selectAllStudents();

	void addStudent(Student student);

	Student selectStudent(String npm);
	
	void deleteStudent(String npm);
}

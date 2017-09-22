package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Student;

public class InMemoryStudentService implements StudentService {
	private static List<Student> studentList = new ArrayList<Student>();

	@Override
	public Student selectStudent(String npm) {
		// Implement
		Student a = null;
		int size = studentList.size();
		for (int i = 0; i < size; i++) {
			if (studentList.get(i).getNpm().equals(npm)) {
				a = studentList.get(i);
				break;
			}
		}
		return a;

	}

	@Override
	public List<Student> selectAllStudents() {
		return studentList;
	}

	@Override
	public void addStudent(Student student) {
		studentList.add(student);
	}

	@Override
	public void deleteStudent(String npm) {
		// Implement
		Student a = null;		
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getNpm().equals(npm)) {
				System.out.println(studentList.get(i));
				studentList.remove(i);
				break;
			}
		}
	}

	/*
	 * @Override public Student selectStudent(Optional<String> npm) { // TODO
	 * Auto-generated method stub Student a = null; int size =
	 * studentList.size(); for (int i = 0; i < size; i++) { if
	 * (studentList.get(i).getNpm().equals(npm)) { a = studentList.get(i);
	 * break; } } return a; }
	 */
}
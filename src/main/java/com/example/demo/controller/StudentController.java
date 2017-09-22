package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Student;
import com.example.demo.service.InMemoryStudentService;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {
	private final StudentService studentService;

	public StudentController() {
		studentService = new InMemoryStudentService();
	}

	@RequestMapping("/student/add")
	public String add(@RequestParam(value = "npm", required = true) String npm,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "gpa", required = true) double gpa) {
		Student student = new Student(name, npm, gpa);
		studentService.addStudent(student);
		return "add";
	}

	/*
	 * @RequestMapping("/student/view") public String view(Model
	 * model, @RequestParam(value = "npm", required = true) String npm){ Student
	 * student = studentService.selectStudent(npm);
	 * model.addAttribute("student", student); return "view"; }
	 */

	@RequestMapping("/student/viewall")
	public String viewAll(Model model) {
		List<Student> students = studentService.selectAllStudents();
		model.addAttribute("students", students);
		return "viewall";
	}

	@RequestMapping("/student/view/{npm}")
	public String view2(@PathVariable String npm, Model model) {
		Student student = studentService.selectStudent(npm);
		model.addAttribute("student", student);
		System.out.println(student.getName() + " " + student.getNpm());
		if (student == null) {
			return "error";
		} else {

			return "view";
		}
	}

	@RequestMapping("/student/delete/{npm}")
	public String delete(@PathVariable String npm, Model model) {
		Student student = studentService.selectStudent(npm);
		//studentService.addStudent(student);
		if (student == null) {
		return "error";
		}else{
			studentService.deleteStudent(npm);
			return "delete";
		}
	}
}
package com.example.demo.model;

public class Student {
	//pake private biar aman
	private String name;
	private String npm;
	private Double gpa;

	public Student(String name, String npm, Double gpa) {
		super();
		this.name = name;
		this.npm = npm;
		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNpm() {
		return npm;
	}

	public void setNpm(String npm) {
		this.npm = npm;
	}

	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

}

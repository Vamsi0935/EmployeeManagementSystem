package com.codegnan.beans;

public class Employee {

	protected int id;
	protected String fullname;
	protected String gender;
	protected String email;
	protected double salary;
	protected String skills;
	protected String role;
	protected String qualification;
	protected String state;

	public Employee(int id, String fullname, String gender, String email, double salary, String skills, String role,
			String qualification, String state) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.gender = gender;
		this.email = email;
		this.salary = salary;
		this.skills = skills;
		this.role = role;
		this.qualification = qualification;
		this.state = state;
	}

	public Employee(String fullname, String gender, String email, double salary, String skills, String role,
			String qualification, String state) {
		super();
		this.fullname = fullname;
		this.gender = gender;
		this.email = email;
		this.salary = salary;
		this.skills = skills;
		this.role = role;
		this.qualification = qualification;
		this.state = state;
	}

	public Employee(int id, String fullname, String email, double salary, String skills, String role) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.salary = salary;
		this.skills = skills;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}

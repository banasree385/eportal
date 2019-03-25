package com.sg.eportal.model;

import java.sql.Date;

public class Employee {
	
	private long employeeId;
	private String firstName;
	private String lastName;
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	private String gender;
	private Date dob;
	private String dobFormatted;
	private String department;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getDobFormatted() {
		return dobFormatted;
	}
	public void setDobFormatted(String dobFormatted) {
		this.dobFormatted = dobFormatted;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Employee() {
		super();
	}
	
	
	public Employee(String firstName, String lastName, String gender, String department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.department = department;
	}
	
	

}

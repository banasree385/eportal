package com.sg.eportal.response;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.Scope;

import com.sg.eportal.model.Employee;


@Scope("request")
public class EmployeeListResponse extends Response implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Employee> employeeList;
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
	
	

}

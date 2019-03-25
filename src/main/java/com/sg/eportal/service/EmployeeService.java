package com.sg.eportal.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sg.eportal.model.Employee;


public interface EmployeeService {
	
	public List<Employee> getEmployee();
	public boolean saveEmployee(Employee employee) throws ParseException;

}

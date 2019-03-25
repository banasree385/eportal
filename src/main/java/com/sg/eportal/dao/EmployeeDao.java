package com.sg.eportal.dao;

import java.util.List;

import com.sg.eportal.model.Employee;

public interface EmployeeDao {
	public List<Employee> getEmployees();
	public boolean saveEmployee(Employee employee);

}

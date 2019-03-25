package com.sg.eportal.mapper;

import java.util.List;

import com.sg.eportal.model.Employee;


public interface EmployeeMapper {
	public List<Employee> getEmployees();
	public int saveEmployee(Employee employee);

}

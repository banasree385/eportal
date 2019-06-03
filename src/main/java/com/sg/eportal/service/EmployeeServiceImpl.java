package com.sg.eportal.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.eportal.dao.EmployeeDao;
import com.sg.eportal.model.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		List<Employee> employees=new ArrayList<>();
		/*Employee e1=new Employee("banasree", "saha", "female", "Capital");
		employees.add(e1);*/
		return employeeDao.getEmployees();
	}
	
	@Override
	public boolean saveEmployee(Employee employee) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd.MM.yyyy");
		Date date = sdf1.parse(employee.getDobFormatted());
		employee.setDob(new java.sql.Date(date.getTime()));
		
		return employeeDao.saveEmployee(employee);
	}

}

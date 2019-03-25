package com.sg.eportal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sg.eportal.mapper.EmployeeMapper;
import com.sg.eportal.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EmployeeMapper employeeMapper;
	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeMapper.getEmployees();
	}

	@Override
	public boolean saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		int result=0;
		result= employeeMapper.saveEmployee(employee);
		if(result>0) return true;
		else return false;
	}

}

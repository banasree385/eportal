package com.sg.eportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sg.eportal.model.Employee;
import com.sg.eportal.response.EmployeeListResponse;
import com.sg.eportal.response.Response;
import com.sg.eportal.service.EmployeeService;



@RestController ("EmployeeController")
public class EmployeeController extends AbstractController{
	
	@Autowired
	@Qualifier("employeeService")
	private EmployeeService employeeService;
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public @ResponseBody Response getEmployees()throws Exception
	{
		EmployeeListResponse response=new EmployeeListResponse();
		List<Employee> employeeList =employeeService.getEmployee();
        response.setEmployeeList(employeeList);
		return setAndReturnSuccessResponse(response);
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.POST,consumes ={"application/json;charset=utf-8"})
	public @ResponseBody Response saveEmployee(@RequestBody Employee employee)throws Exception
	{
		Response response=new Response();
		boolean status =employeeService.saveEmployee(employee);
		response.setSuccess(status);      
		return setAndReturnSuccessResponse(response);
	}

}

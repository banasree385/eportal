package com.sg.eportal.controller;





import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.sg.eportal.EportalApplication;

@RunWith(SpringJUnit4ClassRunner.class)   // 1
@ContextConfiguration(classes = EportalApplication.class)  // 2
@TestPropertySource(value={"classpath:application.properties"})
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class EmployeeControllerTest {
	 @Value("${server.port}") 
	    int port;
	@Before
    public void setBaseUri () {
            RestAssured.port = port;
            RestAssured.baseURI = "http://localhost/eportal/v1/"; // replace as appropriate
    }
	
	 @Test
     public void getEmployeesTest() {
		 
		 RequestSpecification httpRequest = RestAssured.given();
		 Response response = (Response) httpRequest.get("employees");
		 System.out.println(response.body());
		 System.out.println("as string"+response.asString());		 
		 response.then().statusCode(200);
		
     }
	
	
	
	 

}

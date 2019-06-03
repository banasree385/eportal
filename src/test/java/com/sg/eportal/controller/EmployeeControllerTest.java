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
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.sg.eportal.EportalApplication;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;
import static com.jayway.restassured.RestAssured.given;

@RunWith(SpringJUnit4ClassRunner.class)   // 1
@ContextConfiguration(classes = EportalApplication.class)  // 2
@TestPropertySource(value={"classpath:application.properties"})
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class EmployeeControllerTest {
	 @Value("${server.port}") 
	    int port;
     String  BASE_URI="http://localhost/eportal/v1/";

	@Before
    public void setBaseUri () {
            RestAssured.port = port;
            RestAssured.baseURI = "http://localhost/eportal/v1/"; // replace as appropriate
    }
	
	 @Test
     public void getEmployeesTest() {
		 
		// RequestSpecification httpRequest = RestAssured.given();
		 Response response = RestAssured.given().get("employees");		 
		 response.then().statusCode(200).assertThat().body("employeeList.employeeId", hasItems(1, 2));
		 response.then().statusCode(200).assertThat().body("employeeList", not(empty()) );		
     }	 
	 @Test
	 public void saveEmployeeTest(){
		 Response response= given().log().everything().contentType(ContentType.JSON)
		 .body("{\"employeeId\": \"0\","
		 		+ "\"firstName\": \"chhabi\","
		 		+ "\"lastName\":\"saha\" ,"
		 		+ "\"gender\":\"F\","
		 		+ "\"dobFormatted\": \"01.01.1990\"," 
		 		+ "  \"department\":\"home\"" +
                 "}").when().post(BASE_URI+"employees");
			System.out.println("POST Response\n" + response.asString());

		 response .then().statusCode(200);
	 }
	 @Test
	 public void saveEmployeeTestShoudThrowException(){
		 Response response= given().log().everything().contentType(ContentType.JSON)
		 .body("{\"employeeId\": \"0\","
		 		+ "\"firstName\": ,"
		 		+ "\"lastName\":\"saha\" ,"
		 		+ "\"gender\":\"F\","
		 		+ "\"dobFormatted\": \"01.01.1990\"," 
		 		+ "  \"department\":\"home\"" +
                 "}").when().post(BASE_URI+"employees");
			System.out.println("POST Response\n" + response.asString());

		 response .then().statusCode(400);
	 }
	
	
	
	 

}

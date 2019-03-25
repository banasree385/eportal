package com.sg.eportal;

//import static org.assertj.core.api.Assertions.assertThat;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


import com.sg.eportal.controller.EmployeeController;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EportalApplicationTests {
	 @Autowired
	    private EmployeeController controller;

	/*@Test
	public void contextLoads() throws Exception{
		assertThat(controller).isNotNull();
	}*/

}

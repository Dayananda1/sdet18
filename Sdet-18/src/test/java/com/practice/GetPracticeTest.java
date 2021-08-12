package com.practice;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
/**
 * Getting resources from the server with BDD
 * @author Dayananda
 *
 */
public class GetPracticeTest 
{
	@Test
	public void getProjects()
	{
		when()
			.get("http://localhost:8084/projects")
		.then()
			.assertThat().statusCode(200)
			.and()
			.assertThat().contentType("application/json")
			.and()
			.log().all();
	}


}

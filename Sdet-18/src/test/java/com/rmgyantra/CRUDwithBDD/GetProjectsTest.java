package com.rmgyantra.CRUDwithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
/**
 * Getting resources from the server with BDD
 * @author Dayananda
 *
 */
public class GetProjectsTest 
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

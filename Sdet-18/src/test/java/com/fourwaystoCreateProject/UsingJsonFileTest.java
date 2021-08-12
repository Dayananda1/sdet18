package com.fourwaystoCreateProject;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
/**
 * Creating project using .json file
 * @author Dayananda
 *
 */
public class UsingJsonFileTest
{
	@Test
	public void usingJson()
	{
		File file = new File("./Test.json");
		given()
			.contentType(ContentType.JSON)
			.body(file)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.log().all()
			.and()
			.assertThat().contentType("application/json");
		
		
		
	}
	
}
	



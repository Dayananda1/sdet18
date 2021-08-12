package com.practice;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
/**
 * Creating project using .json file
 * @author Dayananda
 *
 */
public class UsingJSONTest 
{
	@Test
	public void usingJson()
	{
		File file = new File("./demo.json");
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

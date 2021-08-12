package com.fourwaystoCreateProject;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
/**
 * Creating project with random variable concept
 * @author Dayananda
 *
 */
public class CreateProjectTest 
{
	@Test
	public void create()
	{
		
		Random random = new Random();
		int randomnum = random.nextInt(2000);
		System.out.println(randomnum);
		JSONObject jsobj = new JSONObject();
		
		jsobj.put("createdBy", "Rohit_shetty");
		jsobj.put("projectName", "Khatron ke khiladi"+randomnum+"");
		jsobj.put("status", "on-going");
		jsobj.put("teamsize", 1000);

		given()
			.contentType(ContentType.JSON)
			.body(jsobj)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.log().all()
			.and()
			.assertThat().contentType("application/json");

	}

}

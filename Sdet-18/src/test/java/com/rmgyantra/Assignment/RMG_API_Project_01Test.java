package com.rmgyantra.Assignment;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
/**
 * Create the Project
 * @author Dayananda
 *
 */
public class RMG_API_Project_01Test 
{
	@Test
	public void testcase01()
	{
		Random random = new Random();
		int randomnum = random.nextInt(2000);
		System.out.println(randomnum);

		JSONObject jsobj = new JSONObject();
		
		jsobj.put("createdBy", "rmg");
		jsobj.put("projectName", "rmgProject"+randomnum+"");
		jsobj.put("status", "created");
		jsobj.put("teamsize", 10);

		given()
			.contentType(ContentType.JSON)
			.body(jsobj)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.log().all()
			.and()
			.assertThat().contentType("application/json")
			.assertThat().statusCode(201);

		
	}

}

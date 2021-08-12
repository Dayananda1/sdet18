package com.practice;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
/**
 * Complete update of the resource TY_PROJ_1202 without BDD
 * @author Dayananda
 *
 */
public class UpdatePracticeTest
{
	@Test
	public void updatePractice()
	{
		JSONObject jsobj = new JSONObject();
		jsobj.put("createdBy", "Bhagban Jii");
		jsobj.put("projectName", "pura Brahmand");
		jsobj.put("status", "completed");
		jsobj.put("teamsize", 1000000);
		
		given()
			.contentType(ContentType.JSON)
			.body(jsobj)
		.when()
			.put("http://localhost:8084/projects/TY_PROJ_1202")
		.then()
			.log().all();
		
		
		
	}

}

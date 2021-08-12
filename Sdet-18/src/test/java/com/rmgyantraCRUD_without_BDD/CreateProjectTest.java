package com.rmgyantraCRUD_without_BDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

/**
 * 
 * @author Dayananda
 *Creating a resource without BDD 
 */

public class CreateProjectTest 
{
	@Test
	public void createproject()
	{
		Random random = new Random();
		int randomnum = random.nextInt(2000);
		System.out.println(randomnum);
		
		JSONObject jsobj = new JSONObject();
		
		jsobj.put("createdBy", "Rajnikant");
		jsobj.put("projectName", "Robot"+randomnum+"");
		jsobj.put("status", "completed");
		jsobj.put("teamsize", 1);
		
		RequestSpecification reqspc = RestAssured.given();
		reqspc.contentType(ContentType.JSON);
		reqspc.body(jsobj);
		
		Response rsp = reqspc.post("http://localhost:8084/addProject");
		
		ValidatableResponse vres = rsp.then();
		vres.assertThat().statusCode(201);
		vres.assertThat().contentType("application/json");
		vres.log().all();
		
	}

}

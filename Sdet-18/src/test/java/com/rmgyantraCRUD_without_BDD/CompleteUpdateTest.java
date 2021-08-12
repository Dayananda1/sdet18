package com.rmgyantraCRUD_without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
/**
 * Complete update of the resource TY_PROJ_1002 without BDD
 * @author Dayananda
 *
 */
public class CompleteUpdateTest
{
	@Test
	public void updateproject()
	{
		
		JSONObject jsobj = new JSONObject();
		
		jsobj.put("createdBy", "Rajnikant");
		jsobj.put("projectName", "Chitti_Robot1");
		jsobj.put("status", "completed");
		jsobj.put("teamsize", 1);
		
		RequestSpecification reqspc = RestAssured.given();
		reqspc.contentType(ContentType.JSON);
		reqspc.body(jsobj);
		
		Response rsp = reqspc.put("http://localhost:8084/projects/TY_PROJ_1002");
		
		ValidatableResponse vres = rsp.then();
		vres.assertThat().statusCode(200);
		vres.assertThat().contentType("application/json");
		vres.log().all();
		
	}

}

package com.rmgyantra.CRUDwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
/**
 * Complete update of the resource TY_PROJ_1003 with BDD
 * @author Dayananda
 *
 */
public class CompleteupdateTest {
	@Test
	public void update()
	{
		JSONObject jsobj = new JSONObject();
		jsobj.put("createdBy", "Rocky_bhai");
		jsobj.put("projectName", "Kolar Gold Mine_Fields");
		jsobj.put("status", "on-going");
		jsobj.put("teamsize", 1000000);
		
		given()
			.contentType(ContentType.JSON)
			.body(jsobj)
		.when()
			.put("http://localhost:8084/projects/TY_PROJ_1003")
		.then()
			.log().all();
		
		
		
	}
	

}

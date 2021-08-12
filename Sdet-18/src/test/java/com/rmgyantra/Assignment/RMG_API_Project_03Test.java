package com.rmgyantra.Assignment;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
/**
 * create the project with Text Format
 *@author Dayananda
 */
public class RMG_API_Project_03Test
{
	@Test
	public void testcase03()
	{
	JSONObject jsobj = new JSONObject();
	
	jsobj.put("createdBy", "rmg");
	jsobj.put("projectName", "rmgProject");
	jsobj.put("status", "created");
	jsobj.put("teamsize", 10);

	given()
		.contentType(ContentType.TEXT)
		.body(jsobj)
	.when()
		.post("http://localhost:8084/addProject")
	.then()
		.log().all()
		.and()
		.assertThat().contentType("application/json")
		.assertThat().statusCode(500);

	
}


}

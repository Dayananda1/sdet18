package com.ReqestChaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ChainingTest {
	@Test
	public void chain()
	{
		Response rsp = when().get("http://localhost:8084/projects");
		String firstproId = rsp.jsonPath().get("[5].projectId");
		System.out.println(firstproId);
		
		given()
			.pathParam("proID", firstproId)
		.when()
			.delete("http://localhost:8084/projects/{proID}")
		.then().log().all();
		
	}

}

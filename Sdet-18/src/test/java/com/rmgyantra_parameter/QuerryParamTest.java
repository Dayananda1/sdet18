package com.rmgyantra_parameter;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class QuerryParamTest
{
	@Test
	public void queeryparam()
	{
		given().contentType(ContentType.JSON)
		.queryParam("page", "2")
		.when().get("https://reqres.in/api")
		.then().log().all();
		
	}

}

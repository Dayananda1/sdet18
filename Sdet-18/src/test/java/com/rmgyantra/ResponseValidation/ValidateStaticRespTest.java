package com.rmgyantra.ResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSender;

import static io.restassured.RestAssured.*;

public class ValidateStaticRespTest 
{
	@Test
	public void staticresp()
	{
		String expectedProjName = "Katapa";
		
		Response rsp = when()
		.get("http://localhost:8084/projects");
		
		rsp.then()
		.assertThat().statusCode(200)
		.log().all();
		
		String actualProjName = rsp.jsonPath().get("[0].createdBy");
		System.out.println("expected value is"+expectedProjName);
		System.out.println("actal value is"+actualProjName);
		
		Assert.assertEquals(actualProjName, expectedProjName );
	
	}
	

}

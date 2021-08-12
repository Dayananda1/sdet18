package com.reqres_validation;

import static io.restassured.RestAssured.when;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
/**
 * Validate static Response(on reqres)
 * @author Dayananda
 *
 */
public class Reqres_ValidateStaticRespTest 
{
		@Test
		public void req_staticresp()
		{
			String expectedProjName = "Lawson";
			
			Response rsp = when()
			.get("https://reqres.in/api/users?page=2");
			
			rsp.then()
			.assertThat().statusCode(200)
			.log().all();
			
			String actualProjName = rsp.jsonPath().get("data[0].last_name");
			System.out.println("expected value is"+expectedProjName);
			System.out.println("actal value is"+actualProjName);
			
			Assert.assertEquals(actualProjName, expectedProjName );
		
		}
		


}

package com.reqres_validation;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
/**
 * Validate dynamic Response(on reqres)
 * @author Dayananda
 *
 */
public class Reqres_ValidateDynamicResponse
{
	@Test
	public void req_dynamicResponse()
	{
		String expectedData = "Edwards";
		Object actualData = null;
		Response rsp = when()
		.get("https://reqres.in/api/users?page=2");
		
		List<String> list = rsp.jsonPath().get("data.last_name");
		
		boolean flag = false;
		for(String listdata:list)
		{
			if(listdata.equals(expectedData))
			{
				actualData=expectedData;
				flag=true;
				break;
			}
		}
		Assert.assertEquals(flag, true);
		System.out.println("expected value is"+ expectedData);
		System.out.println("actal value is"+ actualData);
		Assert.assertEquals(actualData, expectedData);
		rsp.then().statusCode(200).log().all();
		
	}


}

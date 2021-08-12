package com.rmgyantra.ResponseValidation;

import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ValidateDyanmicRspTest {
	
	@Test
	public void dynamicResponse()
	{
		String expectedData = "Katapa";
		Object actualData = null;
		Response rsp = when()
		.get("http://localhost:8084/projects");
		
		List<String> list = rsp.jsonPath().get("createdBy");
		
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
		System.out.println("expected value is"+ " "+ expectedData);
		System.out.println("actal value is"+" "+ actualData);
		Assert.assertEquals(actualData, expectedData);
		rsp.then().statusCode(200).log().all();
		
	}

}

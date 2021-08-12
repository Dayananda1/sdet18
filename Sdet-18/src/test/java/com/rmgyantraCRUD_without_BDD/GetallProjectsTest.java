package com.rmgyantraCRUD_without_BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

/**
 * Getting resources from the server without BDD
 * @author DAYANANDA
 * 
 *
 */
public class GetallProjectsTest
{
	@Test
	public void getProjects()
	{
		Response rsp = RestAssured.get("http://localhost:8084/projects");
		//System.out.println(rsp.asString());
		//rsp.prettyPrint();
		System.out.println(rsp.getContentType());
		System.out.println(rsp.statusCode());
		System.out.println(rsp.getTime());


		ValidatableResponse vrsp = rsp.then();
		vrsp.assertThat().statusCode(200);
		vrsp.assertThat().contentType("application/json");
		vrsp.log().all();

	}

}

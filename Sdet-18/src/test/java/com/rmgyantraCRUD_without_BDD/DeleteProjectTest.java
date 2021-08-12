package com.rmgyantraCRUD_without_BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

/**
 * Deleting the project id TY_PROJ_1002(without BDD)
 * @author Dayananda
 *
 */
public class DeleteProjectTest 
{
	@Test
	public void deleteproject()
	{
		
		Response rsp = RestAssured.delete("http://localhot:8084/projects/TY_PROJ_1002");
		
		ValidatableResponse vrsp = rsp.then();
		vrsp.assertThat().contentType("application/json");
		vrsp.assertThat().statusCode(204);
		vrsp.log().all();
		
	}

}

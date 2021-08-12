package com.practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
/**
 * Deleting project id TY_PROJ_1002 (created using json file) without BDD technique
 * @author Dayananda
 *
 */
public class DeletePracticeTest {
	@Test
	public void deletePracticeproject()
	{
		
		Response rsp = RestAssured.delete("http://localhot:8084/projects/TY_PROJ_1002");
		
		ValidatableResponse vrsp = rsp.then();
		vrsp.assertThat().contentType("application/json");
		vrsp.assertThat().statusCode(204);
		vrsp.log().all();
		
	}

}

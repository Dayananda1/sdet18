package com.practice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
/**
 * Deleting project id TY_PROJ_1203 (created using hashmap) without BDD technique
 * @author ACER
 *
 */
public class DeletePracticeHashmapTest 
{
{
		
		Response rsp = RestAssured.delete("http://localhot:8084/projects/TY_PROJ_1203");
		
		ValidatableResponse vrsp = rsp.then();
		vrsp.assertThat().contentType("application/json");
		vrsp.assertThat().statusCode(204);
		vrsp.log().all();
		
	}

}

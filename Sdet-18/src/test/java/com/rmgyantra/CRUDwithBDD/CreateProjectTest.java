package com.rmgyantra.CRUDwithBDD;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
/**
 * Creating a resource in server with BDD 
 * @author DAYANANDA
 *
 */

public class CreateProjectTest {
	@Test
	public void create() {
		
		Random random = new Random();
		int randomnum = random.nextInt(2000);
		System.out.println(randomnum);

		JSONObject jsobj = new JSONObject();
		
		jsobj.put("createdBy", "Rocky bhai");
		jsobj.put("projectName", "Kolar Gold Fields"+randomnum+"");
		jsobj.put("status", "on-going");
		jsobj.put("teamsize", 1000000);

		given()
			.contentType(ContentType.JSON)
			.body(jsobj)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.log().all()
			.and()
			.assertThat().contentType("application/json");


	}

}

package com.fourwaystoCreateProject;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
/**
 * Creating project using Hashmap
 * @author Dayananda
 *
 */
public class UsinghashMapTest
{
	@Test
	public void createHashmap()
	{
		Random random = new Random();
		int randomnum = random.nextInt(2000);
		System.out.println(randomnum);
		
		HashMap map = new HashMap();
		
		map.put("createdBy", "Heeralal");
		map.put("projectName", "bus service"+randomnum+"");
		map.put("status", "on-going");
		map.put("teamsize", 1);
		
		given()
			.contentType(ContentType.JSON)
			.body(map)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
		.log().all()
		.and()
		.assertThat().contentType("application/json");
		
	}

}

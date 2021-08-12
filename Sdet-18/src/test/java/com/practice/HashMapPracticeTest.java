package com.practice;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
/**
 * Creating project using Hashmap
 * @author Dayananda
 *
 */
public class HashMapPracticeTest 
{
	@Test
	public void createHashmap()
	{
		Random random = new Random();
		int randomnum = random.nextInt(2000);
		System.out.println(randomnum);
		
		HashMap map = new HashMap();
		
		map.put("createdBy", "Uday & majnu bhai");
		map.put("projectName", "mafia"+randomnum+"");
		map.put("status", "on-going");
		map.put("teamsize", 2);
		
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

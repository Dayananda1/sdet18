package com.fourwaystoCreateProject;

import org.testng.annotations.Test;

import com.ProjectLibTest.ProjectLib;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;
/**
 * Created project using globalVariable
 * @author Dayananda
 *
 */
public class UsingprojoLibTest 
{
	@Test
	public void createpojo()
	{
		Random random = new Random();
		int randomnum = random.nextInt(5000);
		System.out.println(randomnum);
		ProjectLib pojoObject = new ProjectLib("testing", "testyantra_online"+randomnum,"on-going" , 17);
		
		given()
		.contentType(ContentType.JSON)
		.body(pojoObject)
	.when()
		.post("http://localhost:8084/addProject")
	.then()
	.log().all()
	.and()
	.assertThat().contentType("application/json")
	.and()
	.assertThat().statusCode(201);
	
		
		
	}
	
	

}

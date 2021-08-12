package com.rmgyantra.ResponseValidation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ProjectLibTest.ProjectLib;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateUsingMultipleDataTest 
{
	@Test(dataProvider = "provideData")
	public void createProject(String createdBy,String projectName,String statuscode,int teamSize)
	{
		
		ProjectLib pojoObject = new ProjectLib(createdBy, projectName, statuscode, teamSize);
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
	@DataProvider
	public Object[][] provideData() {
		Object[][] objArray = new Object[3][4];
		objArray[0][0]="golmal";
		objArray[0][1]="Rohit";
		objArray[0][2]="completed";
		objArray[0][3]=1;
		
		objArray[1][0]="golmal2";
		objArray[1][1]="Rohir_shetty";
		objArray[1][2]="completed";
		objArray[1][3]=2;
		
		objArray[2][0]="golmal3";
		objArray[2][1]="Rohit_shetty";
		objArray[2][2]="Completed";
		objArray[2][3]=3;
		
		return objArray;
	}
	

}

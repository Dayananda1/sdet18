package com.ReqestChaining;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ProjectLibTest.ProjectLib;
import com.rmgyantra.genricLibs.BaseClass;
import com.rmgyantra.genricLibs.DatabaseUtilities;
import com.rmgyantra.genricLibs.Endpoints;
import com.rmgyantra.genricLibs.JSONUtility;
import com.rmgyantra.genricLibs.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Verification_wrt_Framework extends BaseClass
{
	@Test
	   public void createProject() throws Throwable 
	{
		
		    JavaUtility javautils = new JavaUtility();
		    JSONUtility jsonUtils = new JSONUtility();
		    DatabaseUtilities dbUtility = new DatabaseUtilities();
			
			String expectedProjectName="Housefull"+javautils.randomNumber();
			String expectedStatus="completed";
			
			//create a resource inside the server using pojo class
			ProjectLib projectlib = new ProjectLib("Akki", expectedProjectName, expectedStatus, 100);
			
			//Give precondition and Capture the response after doing post operation
			Response response = given()
			  .contentType(ContentType.JSON)
			  .body(projectlib)
			 .when().post(Endpoints.addProject_EP);
			
			//Capture projectName and statuscode from the response
			String responseProjectName=jsonUtils.getJsonPathData("projectName", response);
			String responseStatus=jsonUtils.getJsonPathData("status", response);
			
			//Provide the restassured verification
			response.then()
			        .assertThat().statusCode(201)
			        .assertThat().contentType(ContentType.JSON)
			        .log().all();
		
			  String querry="select * from project";
			  String actualProjectName = dbUtility.executeQuerryAndGetData(querry, 4, expectedProjectName);
			  String actualstatus=dbUtility.executeQuerryAndGetData(querry, 5, expectedStatus);
			  
			  //assertion for both db and response body projectname
			  Assert.assertEquals(actualProjectName, expectedProjectName);
			  Assert.assertEquals(responseProjectName, expectedProjectName);
			  
			  //assertion for both db and response body status
			  Assert.assertEquals(actualstatus, expectedStatus);
			  Assert.assertEquals(responseStatus, expectedStatus);
			  
	 }

}

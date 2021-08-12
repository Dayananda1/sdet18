package com.ReqestChaining;

import static io.restassured.RestAssured.*;

import java.lang.reflect.UndeclaredThrowableException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.ProjectLibTest.ProjectLib;
import com.mysql.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Verification_wrt_Database 
{
	@Test
	public void createpojo() throws Throwable 
	{
		Random random = new Random();
		int randomnum = random.nextInt(5000);
		System.out.println(randomnum);
		
		String expectedProjectname = "Housefull"+randomnum;
		String expectedStatus = "completed";
		
		ProjectLib pojoObject = new ProjectLib("Akki", expectedProjectname ,expectedStatus , 100);
		
		Response rsp = given()
		.contentType(ContentType.JSON)
		.body(pojoObject)
	.when()
		.post("http://localhost:8084/addProject");
	
	String rspProjectName = rsp.jsonPath().get("projectName");
	String rspStatus = rsp.jsonPath().get("status");
	
	rsp.then()
	.log().all()
	.and()
	.assertThat().contentType("application/json")
	.and()
	.assertThat().statusCode(201);
	
	//step 1 : register/Load the data base
    Driver driverRef = new Driver();
    DriverManager.registerDriver(driverRef);
    //step 2 : connect to database
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root","root");
    
    //step 3 : issue /  get SQL statement object
    Statement stat =  conn.createStatement();
    
    //step 4 : execute query
    String actualProjectName = null;
    String actualStatus = null;
    boolean flag = false;
    
    ResultSet result =  stat.executeQuery("select * from project");
    
    //display
    while (result.next()) 
    {
    	if(result.getString(4).equals(expectedProjectname))
    	{
    		actualProjectName=result.getString(4);
    		actualStatus=result.getString(5);
    		flag=true;
    		break;
    		
    	}
    }
    
    conn.close();
    
    Assert.assertEquals(flag, true);
    Assert.assertEquals(actualProjectName, expectedProjectname);
    
    Assert.assertEquals(actualStatus, expectedStatus);
	}

}

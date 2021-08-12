package com.rmgyantra.Assignment;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
/**
 * Create_Project_and_Allocate_USER
 * @author Dayananda
 *
 */
public class API_TC_1Test 
{
	@Test
	public void endtoend() throws Throwable 
	{
		Random random = new Random();
		int randomnum = random.nextInt(2000);
		int randomnum1 = random.nextInt(100);
		System.out.println(randomnum);
		
		//------------------creating new projectname------------------------/
		
		JSONObject jsobj = new JSONObject();
		
		jsobj.put("createdBy", "deepak");
		jsobj.put("projectName", "airtel"+"-"+randomnum+"");
		jsobj.put("status", "created");
		jsobj.put("teamsize", 12);

		RequestSpecification reqspec = given()
										.contentType(ContentType.JSON)
										.body(jsobj);
		Response rsp = reqspec.when()
								.post("http://localhost:8084/addProject");
		rsp.then()
			.log().all();
		String proname = rsp.jsonPath().get("projectName");//capturing the projectName
		System.out.println(proname);
		
		//-------------------Creating a employee by Assigning projectValue using captured projectname------------------------//
		
		JSONObject jsobj2 = new JSONObject();
		
		jsobj2.put("designation", "SDET");
		jsobj2.put("dob", "25/05/1999");
		jsobj2.put("email", "nithesh@gmail.com");
		jsobj2.put("empName", "nithesh");
		jsobj2.put("experience", 15);
		jsobj2.put("mobileNo", "9888777657");
		jsobj2.put("project",proname+"" );
		jsobj2.put("role", "ROLE_ADMIN");
		jsobj2.put("username","nithesh"+randomnum1+"");
		
	RequestSpecification abc1 = given()
									.contentType(ContentType.JSON)
									.body(jsobj2);
	Response abc2 = abc1.when()
							.post("http://localhost:8084/employees");
	
	String usName = abc2.jsonPath().get("username");//capturing unique username associated with allocation of projectName
	
	System.out.println("Captured username from newly created project"+"  Where project name is "+proname+" and username is "+usName);
	
	//-------Verification of captured Username in Database (verifying the presence) -------------------------------/
	
	String expectedData = usName;
	String actualData = null;
	Response rsp1 = when()
						.get("http://localhost:8084/employees");
	
	List<String> list = rsp1.jsonPath().get("username");
	
	boolean flag = false;
	for(String listdata:list)
	{
		if(listdata.equals(expectedData))
		{
			actualData=expectedData;
			flag=true;
			break;
		}
	}
	
	//============verification in DATABASE=================================//
	
	//step 1 : register/Load the data base
    Driver driverRef = new Driver();
    DriverManager.registerDriver(driverRef);
    //step 2 : connect to database
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root","root");
    
    //step 3 : issue /  get SQL statement object
    Statement stat =  conn.createStatement();
    
    String actualdataDB = null;
    //step 4 : execute query
    ResultSet result =  stat.executeQuery("select * from employee");
    
    //display
    while (result.next()) 
    {
    	if(result.getString(11).equals(expectedData))
    	{
    		actualdataDB=result.getString(11);
    		break;
    		
    	}
    }
    
    conn.close();
	//Assert.assertEquals(flag, true);
	System.out.println("expected useraname value is"+ " "+ expectedData);
	System.out.println("actal username value is"+" "+ actualData);
	//Verification beteween actal and expected from response
	Assert.assertEquals(actualData, expectedData);
	//Verification beteween actal and expected from DATABASE
	Assert.assertEquals(actualdataDB, expectedData);
	rsp.then().log().all();
	
	}
}


















	/*String expectedData = proname;
	Object actualData = null;
	Response rsp1 = when()
	.get("http://localhost:8084/employees");
	
	List<String> list = rsp1.jsonPath().get("project");
	//String abc = rsp1.jsonPath().get("username");
	//System.out.println(abc);
	
	boolean flag = false;
	for(String listdata:list)
	{
		if(listdata.equals(expectedData))
		{
			actualData=expectedData;
			flag=true;
			break;
		}
	}
	Assert.assertEquals(flag, true);
	System.out.println("expected value is"+ " "+ expectedData);
	System.out.println("actal value is"+" "+ actualData);
	Assert.assertEquals(actualData, expectedData);
	rsp.then().log().all();
	*/
	
	
		




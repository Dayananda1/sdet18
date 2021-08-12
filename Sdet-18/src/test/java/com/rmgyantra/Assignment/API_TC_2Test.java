package com.rmgyantra.Assignment;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.Random;

/**
 * End 2 End scenrio of 2nd Testcase(create & get User Details)
 * @author Dayananda
 *
 */

public class API_TC_2Test 
{
	@Test
	public void endtoend2()
	{
		Random random = new Random();
		int randomnum = random.nextInt(2000);
		System.out.println(randomnum);
//------------------------Creating new employee data-----------------------//
		
		JSONObject jsobj2 = new JSONObject();
		
		jsobj2.put("designation", "SDET");
		jsobj2.put("dob", "25/05/1999");
		jsobj2.put("email", "paven@gmail.com");
		jsobj2.put("empName", "nithesh");
		jsobj2.put("experience", 15);
		jsobj2.put("mobileNo", "9888777657");
		jsobj2.put("project","pavan" );
		jsobj2.put("role", "ROLE_ADMIN");
		jsobj2.put("username","pavan"+"-"+randomnum+"");
		
		RequestSpecification reqspc = given().contentType(ContentType.JSON).body(jsobj2);
		Response rsp = reqspc.when().post("http://localhost:8084/employees");
		
		String abc = rsp.jsonPath().get("employeeId");//capturing the unique employeeID
		System.out.println("Captured employeeID is "+abc);
		
		System.out.println("Employee details of "+abc+" is :");
		
		//=========Displaying the employee details associated to that employeeID========/
		
		given()
			.pathParam("empID", abc)
		.when()
			.get("http://localhost:8084/employees/{empID}")
		.then()
			.assertThat().statusCode(200)
			.log().all();
		
	}

}

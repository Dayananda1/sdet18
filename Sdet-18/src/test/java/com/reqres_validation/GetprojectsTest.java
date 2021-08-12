package com.reqres_validation;

import static io.restassured.RestAssured.*;

import javax.annotation.meta.When;

import org.testng.annotations.Test;

public class GetprojectsTest {
	@Test
	public void getProjects()
	{
		when()
		.get("https://reqres.in/api/users?page=2")
		.then().log().all();
		
	}
	

}

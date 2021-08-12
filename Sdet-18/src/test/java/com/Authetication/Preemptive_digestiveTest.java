package com.Authetication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class Preemptive_digestiveTest 
{
	@Test
	public void preemtiveAuth()
	{
		given()
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.when().get("http://localhost:8084/login")
		.then().log().all().assertThat().statusCode(202);
	}
	
	@Test
	public void digestiveAuth()
	{
		given()
		.auth().digest("rmgyantra", "rmgy@9999")
		.when().get("http://localhost:8084/login")
		.then().log().all().assertThat().statusCode(202);
	}

}

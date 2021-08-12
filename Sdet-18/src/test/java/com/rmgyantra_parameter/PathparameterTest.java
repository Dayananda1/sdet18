package com.rmgyantra_parameter;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PathparameterTest {
	@Test
	public void getProjects()
	{
		given().pathParam("proj", "TY_PROJ_808")
		.when()
		.get("http://localhost:8084/projects/{proj}")
		.then().log().all();
		
	}

}

package com.rmgyantra_parameter;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class HamctrestVerification {
	@Test
	public void ham()
	{
		when().get("http://localhost:8084/projects")
		.then()
			.assertThat().time(Matchers.lessThan(100L),TimeUnit.MILLISECONDS)
			.assertThat().body("[0].projectName", Matchers.equalTo("cd"))
			.log().all();
		
	}

}

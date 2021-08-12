package com.practice;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
/**
 * Deleting project id TY_PROJ_1202 (created using json file) without BDD technique
 * @author Dayananda
 *
 */
public class DeletePracticeBDDTest
{
	@Test
	public void deletePractice()
	{
		when()
			.delete("http://localhost:8084/projects/TY_PROJ_1202")
		.then()
			.assertThat().statusCode(204)
			.and()
			.log().all();
		
	}

}

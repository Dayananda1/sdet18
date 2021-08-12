package com.practice;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
/**
 * Deleting project id TY_PROJ_1203 (created using hashmap) with BDD technique
 * @author Dayananda
 *
 */
public class DeletePracticeHashmapBDDTest 
{

	@Test
	public void deletePracticeHashmap()
	{
		when()
			.delete("http://localhost:8084/projects/TY_PROJ_1203")
		.then()
			.assertThat().statusCode(204)
			.and()
			.log().all();
		
	}


}

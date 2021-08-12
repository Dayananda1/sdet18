package com.rmgyantra.CRUDwithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
/**
 * Deleting project id TY_PROJ_406 resources from the server with BDD
 * @author ACER
 *
 */
public class DeleteProjectTest
{
	@Test
	public void deleteProject()
	{
		when()
			.delete("http://localhost:8084/projects/TY_PROJ_406")
		.then()
			.assertThat().statusCode(204)
			.and()
			.log().all();
		
	}

}

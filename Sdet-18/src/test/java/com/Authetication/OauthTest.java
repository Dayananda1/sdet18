package com.Authetication;

import static io.restassured.RestAssured.*;

import javax.naming.AuthenticationNotSupportedException;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class OauthTest
{
	@Test
	public void oathT2()
	{
		Response rsp = given()
		.formParam("client_id", "Myapp464")
		.formParam("client_secret", "45ec24d002a88b0ee9a12596a1bce24d")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://examples.com")
		
		.when().post("http://coop.apps.symfonycasts.com/token");
		System.out.println(rsp.prettyPrint());
		
		String token = rsp.jsonPath().get("access_token");
		
		given()
			.auth().oauth2(token)
			.pathParam("USER_ID", "2141")
			.when()
				.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/barn-unlock")
				.then().log().all();
		
		
	}	

}

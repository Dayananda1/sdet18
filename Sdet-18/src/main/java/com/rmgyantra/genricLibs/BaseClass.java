package com.rmgyantra.genricLibs;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;
/**
 * configuration to the database
 * @author Dayananda
 *
 */
public class BaseClass 
{
	 DatabaseUtilities db = new DatabaseUtilities();
	@BeforeSuite
	public void configBeforeSuite() 
	{
		System.out.println("=====start=====");
		db.connectToDB();
		System.out.println("===connected to database===");
		baseURI="http://localhost";
		port=8084;
	}
	@AfterSuite
	public void configAfterSuite() throws Throwable
	{
		db.closeDB();
		System.out.println("====database is closed======");
	}

}

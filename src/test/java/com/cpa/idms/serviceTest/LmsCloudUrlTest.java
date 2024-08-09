package com.cpa.idms.serviceTest;

import org.junit.Test;
import org.testng.Assert;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;


public class LmsCloudUrlTest {


	private static String baseUrl = "https://lms-energy.ue.r.appspot.com";
	
	@Test
	public void restAssuredTestGet() {
		io.restassured.RestAssured.baseURI = baseUrl;
		RequestSpecification httpRequest = io.restassured.RestAssured.given();

		Response response = httpRequest.request(Method.GET, "/");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}

	@Test
	public void loginTestPost() {
		io.restassured.RestAssured.baseURI = "https://lms-energy.ue.r.appspot.com/api";

		RequestSpecification httpRequestt = io.restassured.RestAssured.given();
		JSONObject requestParam = new JSONObject();

		requestParam.put("emailID", "admin@gmail.com");
		requestParam.put("password", "Pass1word");

		httpRequestt.header("Content-Type", "application/json");

		httpRequestt.body(requestParam.toJSONString());

		Response responsee = httpRequestt.request(Method.POST, "/authenticate");

		int StatusCode=responsee.getStatusCode();
		Assert.assertEquals(StatusCode,200);  
		System.out.println("Status code is " +StatusCode);
	}

	@Test
	public void updatePasswordTest() {
		io.restassured.RestAssured.baseURI = "https://lms-energy.ue.r.appspot.com/api";

		RequestSpecification httpRequestt = io.restassured.RestAssured.given();
		JSONObject requestParam = new JSONObject();

		requestParam.put("emailID", "ad@gmail.com");
		// requestParam.put("password", "Pass1word");

		httpRequestt.header("Content-Type", "application/json");

		httpRequestt.body(requestParam.toJSONString());

		Response responsee = httpRequestt.request(Method.POST, "/setNewpassword");

		int StatusCode=responsee.getStatusCode();
		Assert.assertEquals(StatusCode,200);  
		System.out.println("Status code is " +StatusCode);
	}

	@Test
	public void listOfCourse() {
		io.restassured.RestAssured.baseURI = "https://lms-energy.ue.r.appspot.com/api/course";


		RequestSpecification httpRequest = io.restassured.RestAssured.given();

		//JSONObject requestParam = new JSONObject();

		//requestParam.get("205f40f5-7fb2-4327-a862-82a928e39190");

		Response response = httpRequest.request(Method.GET, "/lesson?courseID=205f40f5-7fb2-4327-a862-82a928e39190");

		System.out.println(response);

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}

	@Test
	public void newUserRegistrationTest() {
		io.restassured.RestAssured.baseURI = "https://lms-energy.ue.r.appspot.com/api";

		RequestSpecification httpRequestt = io.restassured.RestAssured.given();
		JSONObject requestParam = new JSONObject();

		requestParam.put("courseID", "ffcbd76c-9ae4-49e8-9b79-337e56f048a7");
		requestParam.put("dob", "1556-10-21");
		requestParam.put("emailID", "pawanSingh@gmail.com");
		requestParam.put("name", "PawanJunitTesting");
		requestParam.put("phoneNumber", "7894561230");
		//requestParam.put("password", "Pass1word");

		httpRequestt.header("Content-Type", "application/json");

		httpRequestt.body(requestParam.toJSONString());

		Response responsee = httpRequestt.request(Method.POST, "/createUser");

		int StatusCode=responsee.getStatusCode();
		Assert.assertEquals(StatusCode,200);  
		System.out.println("Status code is " +StatusCode);
	}


}

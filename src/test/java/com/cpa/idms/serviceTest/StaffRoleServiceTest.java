package com.cpa.idms.serviceTest;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.testng.Assert;

import com.cpa.idms.service.admin.dto.StaffRolesDTO;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

public class StaffRoleServiceTest {

	private static String tockenID = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsIlJvbGUiOiJbXSIsImV4cCI6MTYyMDYyNzE0Mn0.lO-NOLx7lAZp4KBXoWiPh8-IL-zfoqhLXkj7r1ZOCB3fPXuYR8ev0mw4IpwoZC4XYnkW_LaGDyeqU1NschVvSw";
	private static String baseUrl = "http://localhost:8080/api/rest/department";
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	
	@Test
	public void retrieveStaffRolesByStaffId() {
		io.restassured.RestAssured.baseURI = baseUrl;
		RequestSpecification httpRequest = io.restassured.RestAssured.given();

		//JSONObject requestParam = new JSONObject();

		//requestParam.put("id","1");

		Response response = httpRequest.request(Method.GET, "/getStaffRolesById?id=1");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}

	@Test
	public void insertStaffRoles() {
		
		StaffRolesDTO staffRoleDtoDto = new StaffRolesDTO();
		io.restassured.RestAssured.baseURI = baseUrl;

		RequestSpecification httpRequestt = io.restassured.RestAssured.given();
		JSONObject requestParam = new JSONObject();

//		requestParam.put("staffRoleId", "1");
		requestParam.put("staff", "1");
		requestParam.put("authority", "CPA");
		requestParam.put("activeFlag", "true");
		requestParam.put("createdDate",dateFormat.format(new Date()));
		requestParam.put("docStatus","OK");
		requestParam.put("createdBy","Pawan");
		requestParam.put("lastUpdatedDate",dateFormat.format(new Date()));
		requestParam.put("lastUpdatedBy","CBSE");
		requestParam.put("staffRoleId","1");
	

		httpRequestt.header("Content-Type", "application/json");
		httpRequestt.body(requestParam.toJSONString());

		Response responsee = httpRequestt.request(Method.POST, "/createStaffRoles");

		int StatusCode=responsee.getStatusCode();
		Assert.assertEquals(StatusCode,200);  
		System.out.println("Status code is " +StatusCode);	
	}

	@Test
	public void retrieveAllStaffRoles() {
       io.restassured.RestAssured.baseURI = baseUrl;
		
		RequestSpecification httpRequest = io.restassured.RestAssured.given();

		Response response = httpRequest.request(Method.GET, "/getAllStaffRoles");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}

	@Test
	public void updateStaffRoles() {
		StaffRolesDTO staffRoleDtoDto = new StaffRolesDTO();
		io.restassured.RestAssured.baseURI = baseUrl;

		RequestSpecification httpRequestt = io.restassured.RestAssured.given();
		JSONObject requestParam = new JSONObject();

//		requestParam.put("staffRoleId", "1");
		requestParam.put("staff", "1");
		requestParam.put("authority", "CPA");
		requestParam.put("activeFlag", "true");
		requestParam.put("createdDate",dateFormat.format(new Date()));
		requestParam.put("docStatus","OK");
		requestParam.put("createdBy","Pawan");
		requestParam.put("lastUpdatedDate",dateFormat.format(new Date()));
		requestParam.put("lastUpdatedBy","CBSE");
		requestParam.put("staffRoleId","1");
		
		httpRequestt.header("Content-Type", "application/json");
		httpRequestt.body(requestParam.toJSONString());

		Response responsee = httpRequestt.request(Method.PUT, "/updateStaffRoles");

		int StatusCode=responsee.getStatusCode();
		Assert.assertEquals(StatusCode,200);  
		System.out.println("Status code is " +StatusCode);
	}

	@Test
	public void deleteById() {
		io.restassured.RestAssured.baseURI = baseUrl;

		RequestSpecification httpRequestt = io.restassured.RestAssured.given();
		JSONObject requestParam = new JSONObject();
		httpRequestt.header("Content-Type", "application/json");
		//JSONObject requestParam = new JSONObject();
		//requestParam.put("id","1");
		httpRequestt.body(requestParam.toJSONString());

		Response responsee = httpRequestt.request(Method.DELETE, "/getStaffRolesById?id=1");
		int StatusCode=responsee.getStatusCode();
		Assert.assertEquals(StatusCode,200);  
		System.out.println("Status code is " +StatusCode);
	}
}



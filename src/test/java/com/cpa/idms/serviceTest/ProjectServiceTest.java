package com.cpa.idms.serviceTest;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.testng.Assert;

import com.cpa.idms.service.admin.dto.ProjectDTO;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

public class ProjectServiceTest {

	private static String tockenID = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsIlJvbGUiOiJbXSIsImV4cCI6MTYyMDYyNzE0Mn0.lO-NOLx7lAZp4KBXoWiPh8-IL-zfoqhLXkj7r1ZOCB3fPXuYR8ev0mw4IpwoZC4XYnkW_LaGDyeqU1NschVvSw";
	private static String baseUrl = "http://localhost:8080/api/rest";
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	
	
	@Test
	public void testRetrieveAllProjects() {
		 io.restassured.RestAssured.baseURI = baseUrl;
			
			RequestSpecification httpRequest = io.restassured.RestAssured.given();

			Response response = httpRequest.request(Method.GET, "/admin/getListOfProjects");

			String responseBody = response.getBody().asString();
			System.out.println("Response Body is =>  " + responseBody);
	}

	@Test
	public void testInsertProject() {
		
		ProjectDTO projectDto = new ProjectDTO();
		io.restassured.RestAssured.baseURI = baseUrl;

		RequestSpecification httpRequestt = io.restassured.RestAssured.given();
		JSONObject requestParam = new JSONObject();

//		requestParam.put("projectId", "1");
		requestParam.put("projectName", "Testing");
		requestParam.put("desc", "Junit");
		requestParam.put("managerId", "1");
		requestParam.put("projectDocumentsId","1");
		requestParam.put("activeFlag","true");
		requestParam.put("createdBy", "Pawan");
		requestParam.put("createdOn", dateFormat.format(new Date()));
		requestParam.put("modifiedBy", "Kumar");
		requestParam.put("modififedOn", dateFormat.format(new Date()));


		httpRequestt.header("Content-Type", "application/json");
		httpRequestt.body(requestParam.toJSONString());

		Response responsee = httpRequestt.request(Method.POST, "/createProject");

		int StatusCode=responsee.getStatusCode();
		Assert.assertEquals(StatusCode,200);  
		System.out.println("Status code is " +StatusCode);	
	}

	@Test
	public void testRetrieveProjectById() {
		
		io.restassured.RestAssured.baseURI = baseUrl;


		RequestSpecification httpRequest = io.restassured.RestAssured.given();

		//JSONObject requestParam = new JSONObject();

		//requestParam.put("id","1");

		Response response = httpRequest.request(Method.GET, "/getProjectById?id=1");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}

	@Test
	public void testUpdateProject() {
		
		ProjectDTO projectDto = new ProjectDTO();
		io.restassured.RestAssured.baseURI = baseUrl;

		RequestSpecification httpRequestt = io.restassured.RestAssured.given();
		JSONObject requestParam = new JSONObject();

//		requestParam.put("projectId", "1");
		requestParam.put("projectName", "Testing Classes");
		requestParam.put("desc", "Junit Testing");
		requestParam.put("managerId", "1");
		requestParam.put("projectDocumentsId","1");
		requestParam.put("activeFlag","true");
		requestParam.put("createdBy", "Pawan");
		requestParam.put("createdOn", dateFormat.format(new Date()));
		requestParam.put("modifiedBy", "Kumar");
		requestParam.put("modififedOn", dateFormat.format(new Date()));

		httpRequestt.header("Content-Type", "application/json");
		httpRequestt.body(requestParam.toJSONString());

		Response responsee = httpRequestt.request(Method.POST, "/updateProject");

		int StatusCode=responsee.getStatusCode();
		Assert.assertEquals(StatusCode,200);  
		System.out.println("Status code is " +StatusCode);	
	}

	@Test
	public void testDeleteById() {
		io.restassured.RestAssured.baseURI = baseUrl;

		RequestSpecification httpRequestt = io.restassured.RestAssured.given();
		JSONObject requestParam = new JSONObject();
		httpRequestt.header("Content-Type", "application/json");
		//JSONObject requestParam = new JSONObject();
		//requestParam.put("id","1");
		httpRequestt.body(requestParam.toJSONString());

		Response responsee = httpRequestt.request(Method.DELETE, "/removeProjectById?id=1");
		int StatusCode=responsee.getStatusCode();
		Assert.assertEquals(StatusCode,200);  
		System.out.println("Status code is " +StatusCode);
	}

}

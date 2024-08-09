package com.cpa.idms.serviceTest;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;


import org.junit.Test;
import org.testng.Assert;

import com.cpa.idms.service.admin.dto.DocumentCategoryDTO;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

public class DocumentCategoryServiceTest {

	private static String tockenID = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsIlJvbGUiOiJbXSIsImV4cCI6MTYyMDYyNzE0Mn0.lO-NOLx7lAZp4KBXoWiPh8-IL-zfoqhLXkj7r1ZOCB3fPXuYR8ev0mw4IpwoZC4XYnkW_LaGDyeqU1NschVvSw";
	private static String baseUrl = "http://localhost:8080/api/rest/admin";
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	
	
    @Test
	public void retrieveAllDocumentCategories() {
		io.restassured.RestAssured.baseURI = baseUrl;
		RequestSpecification httpRequest = io.restassured.RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/getListOfDocumentCategories");
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}

	@Test
	public void insertDocuemntCategory() {
		DocumentCategoryDTO deptCategoryDto = new DocumentCategoryDTO();
		io.restassured.RestAssured.baseURI = baseUrl;

		RequestSpecification httpRequestt = io.restassured.RestAssured.given();
		JSONObject requestParam = new JSONObject();

		requestParam.put("categoryId", "4");
		requestParam.put("deptId", "4");
		requestParam.put("categoryName", "CSE");
		requestParam.put("categoryDesc", "Computer");
		requestParam.put("visibility", "Department");
		requestParam.put("activeFlag","true");
		requestParam.put("createdBy", "Pawan");
		requestParam.put("createdOn", "15-05-2021");
		requestParam.put("modifiedBy", "Kumar");
		requestParam.put("modififedOn", "06-05-2021");

		httpRequestt.header("Content-Type", "application/json");
		httpRequestt.body(requestParam.toJSONString());

		Response responsee = httpRequestt.request(Method.POST, "/createDocuemntCategory");

		int StatusCode=responsee.getStatusCode();
		Assert.assertEquals(StatusCode,200);  
		System.out.println("Status code is " +StatusCode);
	}

	@Test
	public void retrieveDocuemntCategoryById() {
		io.restassured.RestAssured.baseURI = baseUrl;


		RequestSpecification httpRequest = io.restassured.RestAssured.given();

		//JSONObject requestParam = new JSONObject();

		//requestParam.put("id","1");

		Response response = httpRequest.request(Method.GET, "/getDocuemntCategoryById?id=1");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}

	@Test
	public void testUpdateDocuemntCategory() {
		DocumentCategoryDTO deptCategoryDto = new DocumentCategoryDTO();
		io.restassured.RestAssured.baseURI = baseUrl;

		RequestSpecification httpRequestt = io.restassured.RestAssured.given();
		JSONObject requestParam = new JSONObject();

		requestParam.put("categoryId", "4");
		requestParam.put("deptId", "4");
		requestParam.put("categoryName", "CSE");
		requestParam.put("categoryDesc", "Computer");
		requestParam.put("visibility", "Department");
		requestParam.put("activeFlag","true");
		requestParam.put("createdBy", "Pawan");
		requestParam.put("createdOn", "15-05-2021");
		requestParam.put("modifiedBy", "Kumar");
		requestParam.put("modififedOn", "06-05-2021");

		httpRequestt.header("Content-Type", "application/json");
		httpRequestt.body(requestParam.toJSONString());

		Response responsee = httpRequestt.request(Method.POST, "/updateDocuemntCategory");

		int StatusCode=responsee.getStatusCode();
		Assert.assertEquals(StatusCode,200);  
		System.out.println("Status code is " +StatusCode);
	}

	@Test
	public void testDeleteById() {
		io.restassured.RestAssured.baseURI = baseUrl;


		RequestSpecification httpRequest = io.restassured.RestAssured.given();

		//JSONObject requestParam = new JSONObject();

		//requestParam.put("id","1");

		Response response = httpRequest.request(Method.DELETE, "/removeDocuemntCategoryById?id=1");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}

}

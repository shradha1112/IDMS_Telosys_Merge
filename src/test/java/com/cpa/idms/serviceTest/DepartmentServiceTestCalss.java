package com.cpa.idms.serviceTest;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.testng.Assert;

import com.cpa.idms.service.admin.dto.DepartmentDTO;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

public class DepartmentServiceTestCalss {

	private static String tockenID = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsIlJvbGUiOiJbXSIsImV4cCI6MTYyMDYyNzE0Mn0.lO-NOLx7lAZp4KBXoWiPh8-IL-zfoqhLXkj7r1ZOCB3fPXuYR8ev0mw4IpwoZC4XYnkW_LaGDyeqU1NschVvSw";
	private static String baseUrl = "http://localhost:8080/api/rest/department";
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	
	@Test
	public void getListOfDepartments() {
		io.restassured.RestAssured.baseURI = baseUrl;
		
		RequestSpecification httpRequest = io.restassured.RestAssured.given();
        
		Response response = httpRequest.request(Method.GET, "/getListOfDepartments");
//		httpRequest.auth().form("x-auth-token",tockenID);
//		httpRequest.header("x-auth-token",tockenID);
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}

	@Test
	public void getDepartmentById() {
		io.restassured.RestAssured.baseURI = baseUrl;


		RequestSpecification httpRequest = io.restassured.RestAssured.given();

		//JSONObject requestParam = new JSONObject();

		//requestParam.put("deptId","1");

		Response response = httpRequest.request(Method.GET, "/getDepartmentById?deptId=1");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}

	@Test
	public void getListOfSubDepartments() {
       io.restassured.RestAssured.baseURI = baseUrl;
		
		RequestSpecification httpRequest = io.restassured.RestAssured.given();
	
		Response response = httpRequest.request(Method.GET, "/getListOfSubDepartments");
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}

	@Test
	public void createDepartment() {
		
		DepartmentDTO deptDto = new DepartmentDTO();
		io.restassured.RestAssured.baseURI = baseUrl;

		RequestSpecification httpRequestt = io.restassured.RestAssured.given();
		JSONObject requestParam = new JSONObject();

//		requestParam.put("deptId", "6");
		requestParam.put("deptName", "COMP");
		requestParam.put("deptDesc", "CSE-ENGG");
		requestParam.put("deptHead", "2");
		requestParam.put("activeFlag","false");
		requestParam.put("createdBy", "Pawan");
		requestParam.put("createdOn", dateFormat.format(new Date()));
		requestParam.put("modifiedBy", "Singh");
		requestParam.put("modififedOn", dateFormat.format(new Date()));

		httpRequestt.header("Content-Type", "application/json");
	
//		httpRequestt.auth().form("x-auth-token",tockenID);
		httpRequestt.body(requestParam.toJSONString());

		Response responsee = httpRequestt.request(Method.POST, "/createDepartment");

		int StatusCode=responsee.getStatusCode();
		Assert.assertEquals(StatusCode,200);  
		System.out.println("Status code is " + StatusCode);
	}

	@Test
	public void updateDepartmentById() {
		DepartmentDTO deptDto = new DepartmentDTO();
		io.restassured.RestAssured.baseURI = baseUrl;

		RequestSpecification httpRequestt = io.restassured.RestAssured.given();
		JSONObject requestParam = new JSONObject();

		requestParam.put("deptId", "6");
		requestParam.put("deptName", "COMPUTER ScCIENCE");
		requestParam.put("deptDesc", "CSE-ENGG");
		requestParam.put("deptHead", "Singh JEE");
		requestParam.put("activeFlag","true");
		requestParam.put("createdBy", "Pawan Kumar");
		requestParam.put("createdOn", "15-05-2021");
		requestParam.put("modifiedBy", "Pawan");
		requestParam.put("modififedOn", "06-05-2021");
		
		//requestParam.put("x-auth-token", tockenID)

		httpRequestt.header("Content-Type", "application/json");
//		httpRequestt.header("x-auth-token",tockenID);
		httpRequestt.body(requestParam.toJSONString());

		Response responsee = httpRequestt.request(Method.POST, "/updateDepartmentById");

		int StatusCode=responsee.getStatusCode();
		Assert.assertEquals(StatusCode,200);  
		System.out.println("Status code is " +StatusCode);
	}

	@Test
	public void deleteDepartmentByid() {
		io.restassured.RestAssured.baseURI = baseUrl;

		RequestSpecification httpRequestt = io.restassured.RestAssured.given();
		JSONObject requestParam = new JSONObject();
		httpRequestt.header("Content-Type", "application/json");
		httpRequestt.body(requestParam.toJSONString());

		Response responsee = httpRequestt.request(Method.DELETE, "/removeDepartmentById?deptId=5");

		int StatusCode=responsee.getStatusCode();
		Assert.assertEquals(StatusCode,200);  
		System.out.println("Status code is " +StatusCode);
	}

}

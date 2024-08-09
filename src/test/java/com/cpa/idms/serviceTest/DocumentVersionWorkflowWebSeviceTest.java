package com.cpa.idms.serviceTest;
import static org.junit.Assert.*;

import java.text.SimpleDateFormat;

import org.junit.Test;
import org.testng.Assert;

import com.cpa.idms.service.admin.dto.DepartmentDTO;
import com.cpa.idms.service.admin.dto.DocumentsVersionWorkflowDTO;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

public class DocumentVersionWorkflowWebSeviceTest {

	private static String tockenID = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsIlJvbGUiOiJbXSIsImV4cCI6MTYyMDYyNzE0Mn0.lO-NOLx7lAZp4KBXoWiPh8-IL-zfoqhLXkj7r1ZOCB3fPXuYR8ev0mw4IpwoZC4XYnkW_LaGDyeqU1NschVvSw";
	private static String baseUrl = "http://localhost:8080/api/rest";
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	
	@Test
	public void insertDocumentsVersionWorkflow() {
		DocumentsVersionWorkflowDTO deptDto = new DocumentsVersionWorkflowDTO();
		io.restassured.RestAssured.baseURI = baseUrl;

		RequestSpecification httpRequestt = io.restassured.RestAssured.given();
		JSONObject requestParam = new JSONObject();

		requestParam.put("documentsVersionWorkflowId", "5");
		requestParam.put("approvalStatus", "Approved");
		requestParam.put("documentsVersionWorkflowId", "1");
		requestParam.put("projectDocumentsVersionId", "1");
		requestParam.put("projectDocumentsId","1");
		requestParam.put("staffId","1");
		requestParam.put("docVersionReviewComments","Testing");
		requestParam.put("estimateDay","10");
		requestParam.put("categoryId","1");
		requestParam.put("staffRoleId","1");
		requestParam.put("approverOrder","1");
		requestParam.put("createdBy", "Pawan");
		requestParam.put("createdOn", "15-05-2021");
		requestParam.put("modifiedBy", "Kumar");
		requestParam.put("modififedOn", "06-05-2021");
		requestParam.put("filed1","Testing");
		requestParam.put("filed2","Testing");
		requestParam.put("filed3","Testing");
		requestParam.put("filed4","Testing");


		httpRequestt.header("Content-Type", "application/json");
		httpRequestt.body(requestParam.toJSONString());

		Response responsee = httpRequestt.request(Method.POST, "/createDocumentsVersionWorkflow");

		int StatusCode=responsee.getStatusCode();
		Assert.assertEquals(StatusCode,200);  
		System.out.println("Status code is " +StatusCode);	
	}

	@Test
	public void getAllDocumentsVersionWorkflow() {
        io.restassured.RestAssured.baseURI = baseUrl;
		
		RequestSpecification httpRequest = io.restassured.RestAssured.given();

		Response response = httpRequest.request(Method.GET, "/getAllDocumentsVersionWorkflow");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}

	@Test
	public void getDocumentsVersionWorkflowById() {
		io.restassured.RestAssured.baseURI = baseUrl;


		RequestSpecification httpRequest = io.restassured.RestAssured.given();

		//JSONObject requestParam = new JSONObject();

		//requestParam.put("id","1");

		Response response = httpRequest.request(Method.GET, "/getDocumentsVersionWorkflowById?id=1");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}

	@Test
	public void updateDocumentsVersionWorkflow() {
		DepartmentDTO deptDto = new DepartmentDTO();
		io.restassured.RestAssured.baseURI = baseUrl;

		RequestSpecification httpRequestt = io.restassured.RestAssured.given();
		JSONObject requestParam = new JSONObject();

		requestParam.put("documentsVersionWorkflowId", "5");
		requestParam.put("approvalStatus", "Approved");
		requestParam.put("documentsVersionWorkflowId", "1");
		requestParam.put("projectDocumentsVersionId", "1");
		requestParam.put("projectDocumentsId","1");
		requestParam.put("staffId","1");
		requestParam.put("docVersionReviewComments","New Testing");
		requestParam.put("estimateDay","12");
		requestParam.put("categoryId","1");
		requestParam.put("staffRoleId","1");
		requestParam.put("approverOrder","1");
		requestParam.put("createdBy", "Pawan");
		requestParam.put("createdOn", "15-05-2021");
		requestParam.put("modifiedBy", "Kumar");
		requestParam.put("modififedOn", "06-05-2021");
		requestParam.put("filed1","Testing");
		requestParam.put("filed2","Testing");
		requestParam.put("filed3","Testing");
		requestParam.put("filed4","Testing");
		httpRequestt.header("Content-Type", "application/json");
		httpRequestt.body(requestParam.toJSONString());

		Response responsee = httpRequestt.request(Method.PUT, "/updateDocumentsVersionWorkflow");

		int StatusCode=responsee.getStatusCode();
		Assert.assertEquals(StatusCode,200);  
		System.out.println("Status code is " +StatusCode);
	}

	@Test
	public void testDeleteDocumentsVersionWorkflowById() {
		io.restassured.RestAssured.baseURI = baseUrl;

		RequestSpecification httpRequestt = io.restassured.RestAssured.given();
		JSONObject requestParam = new JSONObject();
		httpRequestt.header("Content-Type", "application/json");
		//JSONObject requestParam = new JSONObject();
		//requestParam.put("id","1");
		httpRequestt.body(requestParam.toJSONString());

		Response responsee = httpRequestt.request(Method.DELETE, "/removeDocumentsVersionWorkflowById?id=1");
		int StatusCode=responsee.getStatusCode();
		Assert.assertEquals(StatusCode,200);  
		System.out.println("Status code is " +StatusCode);
	}

}

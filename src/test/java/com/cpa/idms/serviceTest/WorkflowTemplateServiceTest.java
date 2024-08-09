package com.cpa.idms.serviceTest;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.testng.Assert;

import com.cpa.idms.service.admin.dto.WorkflowTemplateDTO;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

public class WorkflowTemplateServiceTest {

	private static String tockenID = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsIlJvbGUiOiJbXSIsImV4cCI6MTYyMDYyNzE0Mn0.lO-NOLx7lAZp4KBXoWiPh8-IL-zfoqhLXkj7r1ZOCB3fPXuYR8ev0mw4IpwoZC4XYnkW_LaGDyeqU1NschVvSw";
	private static String baseUrl = "http://localhost:8080/api/rest";
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

	@Test
	public void insertWorkflowTemplate() {
		WorkflowTemplateDTO workflowTemplateDto = new WorkflowTemplateDTO();
		io.restassured.RestAssured.baseURI = baseUrl;

		RequestSpecification httpRequestt = io.restassured.RestAssured.given();
		JSONObject requestParam = new JSONObject();

//		requestParam.put("workflowTemplateId", "1");
		requestParam.put("templateDesc", "Approved");
		requestParam.put("templateName", "STS");
		requestParam.put("visibility", "1");
		requestParam.put("createdBy", "Pawan");
		requestParam.put("modifiedBy", "Kumar");
		requestParam.put("modifiedDate", dateFormat.format(new Date()));
		requestParam.put("createdDate", dateFormat.format(new Date()));
		requestParam.put("filed1","Testing");
		requestParam.put("filed2","Testing");
		requestParam.put("filed3","Testing");
		requestParam.put("filed4","Testing");


		httpRequestt.header("Content-Type", "application/json");
		httpRequestt.body(requestParam.toJSONString());

		Response responsee = httpRequestt.request(Method.POST, "/createWorkflowTemplate");

		int StatusCode=responsee.getStatusCode();
		Assert.assertEquals(StatusCode,200);  
		System.out.println("Status code is " +StatusCode);
	}

	@Test
	public void retrieveWorkflowTemplateById() {
		io.restassured.RestAssured.baseURI = baseUrl;
		RequestSpecification httpRequest = io.restassured.RestAssured.given();

		//JSONObject requestParam = new JSONObject();

		//requestParam.put("id","1");

		Response response = httpRequest.request(Method.GET, "/getWorkflowTemplateById?id=1");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}

	@Test
	public void retrieveAllWorkflowTemplate() {
		 io.restassured.RestAssured.baseURI = baseUrl;
			
			RequestSpecification httpRequest = io.restassured.RestAssured.given();

			Response response = httpRequest.request(Method.GET, "/getAllWorkflowTemplate");

			String responseBody = response.getBody().asString();
			System.out.println("Response Body is =>  " + responseBody);
	}

	@Test
	public void updateWorkflowTemplate() {
		WorkflowTemplateDTO workflowTemplateDto = new WorkflowTemplateDTO();
		io.restassured.RestAssured.baseURI = baseUrl;

		RequestSpecification httpRequestt = io.restassured.RestAssured.given();
		JSONObject requestParam = new JSONObject();

//		requestParam.put("workflowTemplateId", "1");
		requestParam.put("templateDesc", "Approved");
		requestParam.put("templateName", "STS");
		requestParam.put("visibility", "1");
		requestParam.put("createdBy", "Pawan");
		requestParam.put("modifiedBy", "Kumar");
		requestParam.put("modifiedDate", dateFormat.format(new Date()));
		requestParam.put("createdDate",dateFormat.format(new Date()));
		requestParam.put("filed1","Testing");
		requestParam.put("filed2","Testing");
		requestParam.put("filed3","Testing");
		requestParam.put("filed4","Testing");

		
		httpRequestt.header("Content-Type", "application/json");
		httpRequestt.body(requestParam.toJSONString());

		Response responsee = httpRequestt.request(Method.PUT, "/updateWorkflowTemplate");

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

		Response responsee = httpRequestt.request(Method.DELETE, "/removeWorkflowTemplateById?id=1");
		int StatusCode=responsee.getStatusCode();
		Assert.assertEquals(StatusCode,200);  
		System.out.println("Status code is " +StatusCode);
	}

}

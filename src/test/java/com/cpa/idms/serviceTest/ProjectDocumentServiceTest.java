package com.cpa.idms.serviceTest;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import com.cpa.idms.service.admin.dto.DepartmentDTO;
import com.cpa.idms.service.admin.dto.DocumentsVersionWorkflowDTO;
import com.cpa.idms.service.admin.dto.ProjectDocumentsDTO;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

public class ProjectDocumentServiceTest {

	private static String tockenID = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsIlJvbGUiOiJbXSIsImV4cCI6MTYyMDYyNzE0Mn0.lO-NOLx7lAZp4KBXoWiPh8-IL-zfoqhLXkj7r1ZOCB3fPXuYR8ev0mw4IpwoZC4XYnkW_LaGDyeqU1NschVvSw";
	private static String baseUrl = "http://localhost:8080/api/rest";
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	
	@Test
	public void insertProjectDocuments() {
		
		ProjectDocumentsDTO projectDocDto = new ProjectDocumentsDTO();
		io.restassured.RestAssured.baseURI = baseUrl;

		RequestSpecification httpRequestt = io.restassured.RestAssured.given();
		JSONObject requestParam = new JSONObject();

//		requestParam.put("projectDocumentsId","1");
		requestParam.put("projectDocumentsVersionId", "1");
		requestParam.put("activeVersionNo", "1");
		requestParam.put("approvalStatus", "Approved");
		requestParam.put("archiveReason", "STS");
		requestParam.put("docStatus","OK");
		requestParam.put("docVisibility","Testing");
		requestParam.put("estimateDay","10");
		requestParam.put("fileName","CBSE");
		requestParam.put("modifiedDate","21");
		requestParam.put("pdfConvertDate",dateFormat.format(new Date()));
		requestParam.put("pdfConvertStatus","Done");
		requestParam.put("pdfObjectId","1");
		requestParam.put("pdfPath","Uploading");
		requestParam.put("projectDocName","CSE");
		requestParam.put("rawObjectId","1");
		requestParam.put("rawFilePath","SSL");
		requestParam.put("webConvDate",dateFormat.format(new Date()));
		requestParam.put("webCovStatus","Done");
		requestParam.put("webObjectId","1");
		requestParam.put("categoryId","1");
		requestParam.put("webPath","1");
		requestParam.put("createdBy", "Pawan");
		requestParam.put("modifiedBy", "Kumar");
		requestParam.put("filed1","Testing");
		requestParam.put("filed2","Testing");
		requestParam.put("filed3","Testing");
		requestParam.put("filed4","Testing");


		httpRequestt.header("Content-Type", "application/json");
		httpRequestt.body(requestParam.toJSONString());

		Response responsee = httpRequestt.request(Method.POST, "/createProjectDocuments");

		int StatusCode=responsee.getStatusCode();
		Assert.assertEquals(StatusCode,200);  
		System.out.println("Status code is " +StatusCode);	
	}

	@Test
	public void retrieveProjectDocumentsById() {
		
		io.restassured.RestAssured.baseURI = baseUrl;
		RequestSpecification httpRequest = io.restassured.RestAssured.given();

		//JSONObject requestParam = new JSONObject();

		//requestParam.put("id","1");

		Response response = httpRequest.request(Method.GET, "/getDocumentsVersionWorkflowById?id=1");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}

	@Test
	public void retrieveAllProjectDocuments() {
       io.restassured.RestAssured.baseURI = baseUrl;
		
		RequestSpecification httpRequest = io.restassured.RestAssured.given();

		Response response = httpRequest.request(Method.GET, "/getAllProjectDocuments");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}

	@Test
	public void updateProjectDocuments() {
		
		io.restassured.RestAssured.baseURI = baseUrl;

		RequestSpecification httpRequestt = io.restassured.RestAssured.given();
		JSONObject requestParam = new JSONObject();

		requestParam.put("activeVersionNo", "1");
		requestParam.put("approvalStatus", "IN-Progress");
		requestParam.put("archiveReason", "STS");
		requestParam.put("projectDocumentsVersionId", "1");
		requestParam.put("projectDocumentsId","1");
		requestParam.put("docStatus","OK");
		requestParam.put("docVisibility","Done");
		requestParam.put("estimateDay","10");
		requestParam.put("fileName","CBSE");
		requestParam.put("modifiedDate","28-09-2121");
		requestParam.put("pdfConvertDate","15-05-2021");
		requestParam.put("pdfConvertStatus","NotDone");
		requestParam.put("pdfObjectId","1");
		requestParam.put("pdfPath","Done");
		requestParam.put("projectDocName","CSE");
		requestParam.put("rawObjectId","1");
		requestParam.put("rawFilePath","SSL");
		requestParam.put("webConvDate","02-02-2021");
		requestParam.put("webCovStatus","Done");
		requestParam.put("webObjectId","1");
		requestParam.put("categoryId","1");
		requestParam.put("webPath","1");
		requestParam.put("createdBy", "Pawan");
		requestParam.put("modifiedBy", "Kumar");
		requestParam.put("filed1","Testing");
		requestParam.put("filed2","Testing");
		requestParam.put("filed3","Testing");
		requestParam.put("filed4","Testing");
		
		httpRequestt.header("Content-Type", "application/json");
		httpRequestt.body(requestParam.toJSONString());

		Response responsee = httpRequestt.request(Method.PUT, "/updateProjectDocuments");

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

		Response responsee = httpRequestt.request(Method.DELETE, "/removeProjectDocumentsById?id=1");
		int StatusCode=responsee.getStatusCode();
		Assert.assertEquals(StatusCode,200);  
		System.out.println("Status code is " +StatusCode);
	}

}

package com.cpa.idms.serviceTest;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.cpa.idms.service.admin.dto.MasterLookupDTO;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

public class MasterLookUpWebServicesTest {

	private static String tockenID = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsIlJvbGUiOiJbXSIsImV4cCI6MTYyMDYyNzE0Mn0.lO-NOLx7lAZp4KBXoWiPh8-IL-zfoqhLXkj7r1ZOCB3fPXuYR8ev0mw4IpwoZC4XYnkW_LaGDyeqU1NschVvSw";
	private static String baseUrl = "http://localhost:8080/api/rest";
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	
	@Test
	public void insertMasterLookup() {
		MasterLookupDTO masterLookUpDto = new MasterLookupDTO();
		io.restassured.RestAssured.baseURI = baseUrl;

		RequestSpecification httpRequestt = io.restassured.RestAssured.given();
		JSONObject requestParam = new JSONObject();

		requestParam.put("lookupId", "1");
		requestParam.put("lookupType", "PDF");
		requestParam.put("lookupCode", "12");
		requestParam.put("lookupDesc", "Computer");
		requestParam.put("activeFlag", "true");
		requestParam.put("organizationId","2");
		requestParam.put("createdBy", "Pawan");
		requestParam.put("createdDate", dateFormat.format(new Date()));
		requestParam.put("lastUpdatedBy", "Kumar");
		requestParam.put("lastUpdatedDate", dateFormat.format(new Date()));

		httpRequestt.header("Content-Type", "application/json");
		httpRequestt.body(requestParam.toJSONString());

		Response response = httpRequestt.request(Method.POST, "/createMasterLookup");
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}

	@Test
	public void getAllMasterLookup() {
		io.restassured.RestAssured.baseURI = baseUrl;
		RequestSpecification httpRequest = io.restassured.RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/getAllMasterLookup");
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}

	@Test
	public void testGetMasterLookupById() {
		io.restassured.RestAssured.baseURI = baseUrl;


		RequestSpecification httpRequest = io.restassured.RestAssured.given();

		//JSONObject requestParam = new JSONObject();

		//requestParam.put("id","1");

		Response response = httpRequest.request(Method.GET, "/getMasterLookupById?id=1");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}

	@Test
	public void updateMasterLookup() {
		MasterLookupDTO masterLookUpDto = new MasterLookupDTO();
		io.restassured.RestAssured.baseURI = baseUrl;

		RequestSpecification httpRequestt = io.restassured.RestAssured.given();
		JSONObject requestParam = new JSONObject();

		requestParam.put("lookupId", "1");
		requestParam.put("lookupType", "xlsx");
		requestParam.put("lookupCode", "12");
		requestParam.put("lookupDesc", "Computer - Desc");
		requestParam.put("activeFlag", "true");
		requestParam.put("organizationId","2");
		requestParam.put("createdBy", "Pawan");
		requestParam.put("createdDate", dateFormat.format(new Date()));
		requestParam.put("lastUpdatedBy", "Kumar");
		requestParam.put("lastUpdatedDate", dateFormat.format(new Date()));

		httpRequestt.header("Content-Type", "application/json");
		httpRequestt.body(requestParam.toJSONString());

		Response responsee = httpRequestt.request(Method.PUT, "/updateMasterLookup");
		String responseBody = responsee.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}

	@Test
	public void deleteMasterLookupById() {
		io.restassured.RestAssured.baseURI = baseUrl;


		RequestSpecification httpRequest = io.restassured.RestAssured.given();

		//JSONObject requestParam = new JSONObject();

		//requestParam.put("id","1");

		Response response = httpRequest.request(Method.DELETE, "/removeMasterLookupById?id=1");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}

}

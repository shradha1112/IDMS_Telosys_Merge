package com.cpa.idms.serviceTest;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StaffMemberServiceTest {

	private static String tockenID = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsIlJvbGUiOiJbXSIsImV4cCI6MTYyMDYyNzE0Mn0.lO-NOLx7lAZp4KBXoWiPh8-IL-zfoqhLXkj7r1ZOCB3fPXuYR8ev0mw4IpwoZC4XYnkW_LaGDyeqU1NschVvSw";
	private static String baseUrl = "http://localhost:8080/api/rest/admin";
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
//	dateFormat.format(new Date())
	@Test
	public void testRetrieveAllStaffMembers() {
		
       io.restassured.RestAssured.baseURI = baseUrl;
		
		RequestSpecification httpRequest = io.restassured.RestAssured.given();

		Response response = httpRequest.request(Method.GET, "/getListOfStaffMembers");

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}

	@Test
	public void testPersistStaffMember() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testFindByEmail() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testUpdatePassword() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRetrieveAllPrimaryProvider() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRetrieveStaffMemberById() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testUpdateStaffMemberById() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetUserLoginTime() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetUserLogoutTime() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetLoginStatus() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testCheckStaffMemberInUse() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRemoveStaffMemberById() {
		fail("Not yet implemented"); // TODO
	}

}

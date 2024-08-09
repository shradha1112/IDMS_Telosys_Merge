package com.cpa.idms.serviceTest;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IDMSBaseServiceTest {

	private static String tockenID = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsIlJvbGUiOiJbXSIsImV4cCI6MTYyMDYyNzE0Mn0.lO-NOLx7lAZp4KBXoWiPh8-IL-zfoqhLXkj7r1ZOCB3fPXuYR8ev0mw4IpwoZC4XYnkW_LaGDyeqU1NschVvSw";
	private static String baseUrl = "http://localhost:8080/api/rest/department";
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	dateFormat.format(new Date())
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCurrentUser() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetPasswordMailSender() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetStudentPwsMailSender() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetUsernameMailSender() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetAdminEmailSender() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetResetPasswordMailSender() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetRandomPassword() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetAdminSubscriptionMailSender() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetSubscriptionActivationMailSender() {
		fail("Not yet implemented"); // TODO
	}

}

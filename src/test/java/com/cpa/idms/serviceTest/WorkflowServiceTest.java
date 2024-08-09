package com.cpa.idms.serviceTest;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WorkflowServiceTest {

	private static String tockenID = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsIlJvbGUiOiJbXSIsImV4cCI6MTYyMDYyNzE0Mn0.lO-NOLx7lAZp4KBXoWiPh8-IL-zfoqhLXkj7r1ZOCB3fPXuYR8ev0mw4IpwoZC4XYnkW_LaGDyeqU1NschVvSw";
	private static String baseUrl = "http://localhost:8080/api/rest/department";
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUploadDocument() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRetrieveAllDocuments() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetApprovalPendingDocuments() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRetrieveWorkflowDetailsById() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testUpdateWorkflowDetails() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testDeleteById() {
		fail("Not yet implemented"); // TODO
	}

}

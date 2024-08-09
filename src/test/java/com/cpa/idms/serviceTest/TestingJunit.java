package com.cpa.idms.serviceTest;


import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.testng.Assert;


import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestingJunit {
	
//	RestAssured.config  = RestAssured.config().sslConfig(SSLConfig.sslConfig()
//            .trustStore(this.getClass().getResource(trustStore).getFile(), trustStorePassword).trustStoreType("JKS")
//            .keyStore(this.getClass().getResource(keyStore).getFile(), keyStorePassword).keystoreType("PKCS12"));
//	  @LocalManagementPort
//	    int managementPort;
	
//	  @LocalServerPort
//	private int port;
//	@Before
//	public void setUp() throws Exception {
//	    RestAssured.port = port;
//	}

	@Test
	public void testRestAssurefdURL () {
		   String accessToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsIlJvbGUiOiJbXSIsImV4cCI6MTYyMDYyNzE0Mn0.lO-NOLx7lAZp4KBXoWiPh8-IL-zfoqhLXkj7r1ZOCB3fPXuYR8ev0mw4IpwoZC4XYnkW_LaGDyeqU1NschVvSw";
		int code = RestAssured.given()
				.header("x-auth-token",accessToken)
		        .when()
		        .get("https://localhost:8081/api/rest/department/getListOfDepartments")
		        .getStatusCode();
		   
		   System.out.println(">>>>>>>>>>>>>>>>>>> Printing " + code);
		}

		
//	RestAssured.baseURI= "https://localhost:8081/auth/login";	
//		
//	PreemptiveBasicAuthScheme authscheme= new PreemptiveBasicAuthScheme();
//	
//	authscheme.setUserName("admin");
//	authscheme.setPassword("Admin@123");
//	
//	RestAssured.authentication=authscheme;
//	
//	RequestSpecification httpsrequestt=RestAssured.given();
//	
//	Response responsee=httpsrequestt.request(Method.POST, "/");
//	
//	String responseeBody=responsee.getBody().asString();
//	
//	System.out.println(responseeBody);
	
	
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
//	RestAssured.baseURI = "https://localhost:8081/api/rest/department/getListOfDepartments";
//	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//	
//	
//	String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsIlJvbGUiOiJbXSIsImV4cCI6MTYyMDYyNzE0Mn0.lO-NOLx7lAZp4KBXoWiPh8-IL-zfoqhLXkj7r1ZOCB3fPXuYR8ev0mw4IpwoZC4XYnkW_LaGDyeqU1NschVvSw";
//	   given().auth()
//	  .oauth2(token)
//	  .when()
//	  .get("https://localhost:8081/api/rest/department/getListOfDepartments")
//	  .then()
//	  .assertThat()
//	  .statusCode(HttpStatus.OK.value());
//	
//    PreemptiveBasicAuthScheme authscheme= new PreemptiveBasicAuthScheme();
	
//	authscheme.setUserName("admin");
//	authscheme.setPassword("Admin@123");
//	String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsIlJvbGUiOiJbXSIsImV4cCI6MTYyMDYyNzE0Mn0.lO-NOLx7lAZp4KBXoWiPh8-IL-zfoqhLXkj7r1ZOCB3fPXuYR8ev0mw4IpwoZC4XYnkW_LaGDyeqU1NschVvSw";
//	RequestSpecification resp = RestAssured.given().header("x-auth-token", token);

	
	
//	authscheme.authenticate(tocken);
	
//	RestAssured.authentication=authscheme;
//	
//	RequestSpecification httpRequest = RestAssured.given();
//	
//	RequestSpecification httpRequestt = RestAssured.given();
//	   
//	   Response response = httpRequestt.request(Method.GET, "/");
//   
//	   System.out.println("Tester after get method");
//	   
//	   String responseBody = response.getBody().asString();
//	   System.out.println("Response Body is =>  " + responseBody);

	//Validating Headers
	   
//	   String contentType=response.header("Content-Type");
//	   String contentEncoding=response.header("Content-Encoding");
//
//	   Assert.assertEquals(contentType, "ACTUAL CONTENT ");
//	   Assert.assertEquals(contentEncoding, "ACTUAL CONTENT ");
	
	}

//private RequestSpecification given() {
//	return null;
//}
//	@Test
//	public void test() {
//		
//	}



package com.cpa.idms.serviceTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.testng.Assert;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

public class UserRegistrationFromExcelTest {

	@Test
	public void restAssuredTestRegister() throws IOException ,IllegalStateException {
		
		io.restassured.RestAssured.baseURI = "https://lms-energy.ue.r.appspot.com/api";

		RequestSpecification httpRequestt = io.restassured.RestAssured.given();
		JSONObject requestParam = new JSONObject();
		
		File src = new File("src/test/java/dataPackage/NewUserRegistrationn.xls");
		
		FileInputStream fis= new FileInputStream(src);
		
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		
		HSSFSheet Sheet1 = wb.getSheetAt(0);
		
		int i=1,j=0;
		
		//for(i=1;i<=6;i++)
		//{
		
			for(j=1;j<=6;j++)
			{
		LocalDateTime dateOfBirth = Sheet1.getRow(j).getCell(1).getLocalDateTimeCellValue();    /////DOB
		
		String userName = Sheet1.getRow(j).getCell(3).getStringCellValue();  //////Name
		
		Long userPhoneNumber = (long) Sheet1.getRow(1).getCell(4).getNumericCellValue();  //////Phone Number
		
		String userEmail = Sheet1.getRow(j).getCell(2).getRichStringCellValue().toString(); //Email
		

		requestParam.put("courseID", "ffcbd76c-9ae4-49e8-9b79-337e56f048a7");
		requestParam.put("dob", dateOfBirth);
		requestParam.put("emailID", userEmail);
		requestParam.put("name", userName);
		requestParam.put("phoneNumber", userPhoneNumber);
		//requestParam.put("password", "Pass1word");

		httpRequestt.header("Content-Type", "application/json");

		httpRequestt.body(requestParam.toJSONString());

		Response responsee = httpRequestt.request(Method.POST, "/createUser");

		int StatusCode=responsee.getStatusCode();
		Assert.assertEquals(StatusCode,200); 
		System.out.println("Status code is " +StatusCode);
			}
		//}
		
		
	}

}

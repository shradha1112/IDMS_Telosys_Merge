package com.cpa.idms.serviceTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.testng.Assert;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

public class ImportDepartmentFromExcelSheet {

	private static String tockenID = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsIlJvbGUiOiJbXSIsImV4cCI6MTYyMDYyNzE0Mn0.lO-NOLx7lAZp4KBXoWiPh8-IL-zfoqhLXkj7r1ZOCB3fPXuYR8ev0mw4IpwoZC4XYnkW_LaGDyeqU1NschVvSw";
	
	@Test
	public void importDepartmentFromExcelSheet()throws IOException ,IllegalStateException,NullPointerException, Exception {

		io.restassured.RestAssured.baseURI = "http://localhost:8080/api/rest/department";

		RequestSpecification httpRequestt = io.restassured.RestAssured.given();
		JSONObject requestParam = new JSONObject();

		File src = new File("src/test/java/dataPackage/NewDepartmentCreation.xls");
//		File src = new File("C://Users/LT_CP_007/Desktop/NewDepartmentCreation.xls");


		FileInputStream fis= new FileInputStream(src);

		HSSFWorkbook wb = new HSSFWorkbook(fis);

		HSSFSheet Sheet1 = wb.getSheetAt(0);

		int j=1;
		for(j=1;j<=10;j++)
		    {

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
	
			// Fetching DepartmentID From the Excel 
			Long departmentId = (long) Sheet1.getRow(j).getCell(0).getNumericCellValue();
			
			//Getting Department Name
			String departmentName = Sheet1.getRow(j).getCell(1).getStringCellValue();
			
			//Getting Department Description 
			String departmentDesc = Sheet1.getRow(j).getCell(2).getStringCellValue();
			
			//Getting Department Head 
			String departmentHead = Sheet1.getRow(j).getCell(3).getStringCellValue();
			
			//Getting CreatedBY
			String createdBy = Sheet1.getRow(j).getCell(5).getStringCellValue();
			
			//Getting Creation Date
//			Date creationDate = Sheet1.getRow(j).getCell(6).getDateCellValue();

			//Getting Modification Date
//			Date modififedOn = Sheet1.getRow(j).getCell(8).getDateCellValue();

			
			//Getting modifiedBy
			String modifiedBy = Sheet1.getRow(j).getCell(7).getStringCellValue();
		
//			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> departmentId " + departmentId);
//			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> createdBy " + createdBy);
//			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> departmentName " + departmentName);
//			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> departmentHead " + departmentHead);
//			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> creationDate " + creationDate);
//			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> modififedOn " + modififedOn);
//			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> modifiedBy " + modifiedBy);
//			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> departmentDesc " + departmentDesc);
			
			

//			requestParam.put("deptId", departmentId);
			requestParam.put("deptName",departmentName);
			requestParam.put("deptDesc", departmentDesc);
			requestParam.put("deptHead", departmentHead);
			requestParam.put("activeFlag","true");
			requestParam.put("createdBy", createdBy);
			requestParam.put("createdOn", dateFormat.format(new Date()));
			requestParam.put("modifiedBy", modifiedBy);
			requestParam.put("modififedOn", dateFormat.format(new Date()));

			httpRequestt.header("Content-Type", "application/json");
//			httpRequestt.auth().form("x-auth-token",tockenID);
//			httpRequestt.header("x-auth-token",tockenID);
			httpRequestt.body(requestParam.toJSONString());

			Response responsee = httpRequestt.request(Method.POST, "/createDepartment");

			int StatusCode=responsee.getStatusCode();
			Assert.assertEquals(StatusCode,200); 
			System.out.println("Status code is " +StatusCode);
			
			
		}

	}

}

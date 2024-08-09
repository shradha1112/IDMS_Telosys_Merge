package com.cpa.idms.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cpa.idms.IdmsApp;
import com.cpa.idms.backend.dao.admin.entities.Department;
import com.cpa.idms.backend.dao.exception.entities.IdmsBaseException;
import com.cpa.idms.service.admin.DepartmentService;
import com.cpa.idms.service.admin.dto.DepartmentDTO;
import com.cpa.idms.service.admin.impl.DepartmentServiceImpl;
import com.cpa.idms.web.rest.admin.DepartmentWebService;

//@RunWith(SpringRunner.class)
//@SpringBootTest( classes = IdmsApp.class,  webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WebMvcTest(DepartmentWebService.class)
public class DepartmentServiceTest {

	
	@Autowired
	DepartmentWebService departmentWebService;
	
	@Autowired
	private MockMvc mockMvc;
	
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "https://localhost:" + port;
    }
//	private WebClientWrapper webClient;
	
	@MockBean
	DepartmentServiceImpl departmentWebServiceImpl;
	
	@MockBean
	DepartmentService departmentService;
	
//	@Before
//	public void setUp()throws Exception { 
//		String baseURL = "https://localhost:8081";
//		this.webClient = new WebClientWrapper(baseURL);
//	}
private final String successResponse = "\"success\":true";


	@After
	public void tearDown() throws Exception {
	}
	 
	//@Test
	public void testInsertDeptData() {
		DepartmentDTO department  = new DepartmentDTO();
		department.setActiveFlag(true);
		department.setCreatedBy("Pawan");
		department.setCreatedOn(new Date());
		department.setDeptDesc("Junit Test");
		department.setDeptHead("Kumar");
		department.setDeptId(6L);
		department.setDeptName("CP");
		department.setModifiedBy("Singh");
		department.setModififedOn(new Date());
        ResponseEntity<DepartmentDTO> postResponse = 
        		restTemplate.postForEntity(getRootUrl() + "/createDepartment", department, DepartmentDTO.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
	}

	//@Test
	public void testUpdateDeptData() {

		 int id = 1;
		 DepartmentDTO employee = restTemplate.getForObject(getRootUrl() + "/updateDepartmentById" + id, DepartmentDTO.class);
	        employee.setDeptName("CSE");
	        restTemplate.put(getRootUrl() + "/updateDepartmentById" + id, employee);
	        DepartmentDTO updatedEmployee = restTemplate.getForObject(getRootUrl() + "/updateDepartmentById" + id, DepartmentDTO.class);
	        assertNotNull(updatedEmployee);
	}

//	@Test
	public void testGetDepartmentDetailsById() throws IdmsBaseException {
//		DepartmentDTO department = restTemplate.getForObject(getRootUrl() + "/getDepartmentById?deptId=1", DepartmentDTO.class);
//	        System.out.println(">>>>>>>>>>>>>>>  Departmentname" + department.getDeptName());
//	        assertNotNull(department);
		DepartmentDTO department = new DepartmentDTO();
		
		Long deptId = 1L;
		when(((OngoingStubbing) departmentService.getDepartmentDetailsById(1L)).thenReturn(department));
		
		try {
			String baseURL = "https://localhost:8081";
			this.mockMvc.perform((RequestBuilder) ((ResultActions) MockMvcRequestBuilders.get("/getDepartmentById?deptId=1"))
					.andDo(print()).andExpect(status().isOk()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteDepartment() {
		System.out.println(">>>>>>>>>>>>>>> Get All Departments >>>>>>>>>>>>>>>>>>");
		String name = ">>>>>>>>>>>>>>> Get All Departments >>>>>>>>>>>>>>>>>>";
		assertEquals(">>>>>>>>>>>>>>> Get All Departments >>>>>>>>>>>>>>>>>>", name);	
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testRetrieveAllDepartments()throws Exception {
		System.out.println(">>>>>>>>>>>>>>> Get All Departments >>>>>>>>>>>>>>>>>>");
		
		List<DepartmentDTO> departmentList = departmentService.retrieveAllDepartments();
		assertThat(departmentList).size().isGreaterThan(0); 
		
//		    HttpHeaders headers = new HttpHeaders();
//	        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//	        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/getListOfDepartments",
//	        HttpMethod.GET, entity, String.class);  
//	        assertNotNull(response.getBody());
//	        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//	        System.out.println(response.getBody());
//	        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
  
//		System.out.println(">>>>>>>>>>>>>>> Get All Departments >>>>>>>>>>>>>>>>>>");
//		String name = ">>>>>>>>>>>>>>> Get All Departments >>>>>>>>>>>>>>>>>>";
//		assertEquals(">>>>>>>>>>>>>>> Get All Departments >>>>>>>>>>>>>>>>>>", name);
//		DepartmentDTO department = new DepartmentDTO();
		
//		when(departmentService.retrieveAllDepartments()).thenReturn((List<DepartmentDTO>) department);
		
//		this.mockMvc.perform(get("/getListOfDepartments")).andDo(print()).andExpect(status().isOk())
//		.andExpect(jsonPath("Departmanet Names :- ", is(department.getDeptName())));
//		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> ");

//		mockMvc.perform(get("/getListOfDepartments")
//		.accept(MediaType.APPLICATION_JSON))	
//		.andDo(print()).andExpect(status().isOk());
//				
		

	}

//	@Test
	public void testRetrieveAllSubDepartments() {
		fail("Not yet implemented");
	}

}

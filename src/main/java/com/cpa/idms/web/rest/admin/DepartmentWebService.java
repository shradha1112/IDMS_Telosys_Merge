package com.cpa.idms.web.rest.admin;

import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.idms.backend.dao.admin.entities.StaffMember;
import com.cpa.idms.backend.dao.exception.entities.IdmsBaseException;
import com.cpa.idms.service.admin.DepartmentService;
import com.cpa.idms.service.admin.IDMSBaseService;
import com.cpa.idms.service.admin.dto.DepartmentDTO;
import com.cpa.idms.service.admin.dto.SubDepartmentDTO;
import com.cpa.idms.util.FormatConverterUtils;

@RestController
@RequestMapping("/api/rest/department")
@CrossOrigin(origins = {"http://localhost:4300"})
public class DepartmentWebService {
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private IDMSBaseService idmsBaseService;

	@GetMapping("/getListOfDepartments")
	public ResponseEntity<List <DepartmentDTO>> getListOfDepartments() {
		List<DepartmentDTO> departmentListResp;
		try {
			departmentListResp = departmentService.retrieveAllDepartments();
			return new ResponseEntity<> (departmentListResp, HttpStatus.OK);
		} catch (IdmsBaseException e) {
			
		}
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
		
	}
	
	@GetMapping("/getDepartmentById")
	public ResponseEntity<DepartmentDTO> getDepartmentById(@RequestParam("deptId") Long deptId) {
		DepartmentDTO departmentObj;
		try {
			departmentObj = departmentService.getDepartmentDetailsById(deptId);
			return new ResponseEntity<> (departmentObj, HttpStatus.OK);
		} catch (IdmsBaseException e) {
			
		}
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
		
	}
	
	@GetMapping("/getListOfSubDepartments")
	public ResponseEntity<List <SubDepartmentDTO>> getListOfSubDepartments() {
		List<SubDepartmentDTO> departmentListResp;
		try {
			departmentListResp = departmentService.retrieveAllSubDepartments();
			return new ResponseEntity<> (departmentListResp, HttpStatus.OK);
		} catch (IdmsBaseException e) {
			
		}
		
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
		
	}	
	
	@PostMapping("/createDepartment")
	public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO insertDeptData){
		try{
			if(insertDeptData!=null) {				
				StaffMember loginUser = idmsBaseService.currentUser();
//				FormatConverterUtils.setInitialDefaultValues(insertDeptData, loginUser);
				
				DepartmentDTO insertedDeptData = departmentService.insertDeptData(insertDeptData);
				return new ResponseEntity<> (insertedDeptData, HttpStatus.OK);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
	}
	
	@PostMapping("/updateDepartmentById")
	public ResponseEntity<DepartmentDTO> updateDepartmentById(@RequestBody DepartmentDTO insertDeptData){
		try{
			if(insertDeptData!=null) {				
				StaffMember loginUser = idmsBaseService.currentUser();
				FormatConverterUtils.setInitialUpdateValues(insertDeptData, loginUser);
				
				DepartmentDTO insertedDeptData = departmentService.updateDeptData(insertDeptData);
				return new ResponseEntity<> (insertedDeptData, HttpStatus.OK);
			}
		}catch (Exception e) {
			//e.printStackTrace();
		}
		
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
	}
	
	@DeleteMapping("/removeDepartmentById")
	public ResponseEntity<Void> deleteDepartmentByid(@RequestParam("deptId") Long deptId){
		HttpHeaders headers= new HttpHeaders();
		try {
			Boolean flag = departmentService.deleteDepartment(deptId);
			if(flag)
				return new ResponseEntity<> (headers, HttpStatus.OK);
			else
				return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
	}
	
}

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

import com.cpa.idms.service.admin.DepartmentService;
import com.cpa.idms.service.admin.DocumentCategoryService;
import com.cpa.idms.service.admin.ProjectService;
import com.cpa.idms.service.admin.StaffMemberService;
import com.cpa.idms.service.admin.dto.DepartmentDTO;
import com.cpa.idms.service.admin.dto.DocumentCategoryDTO;
import com.cpa.idms.service.admin.dto.ProjectDTO;
import com.cpa.idms.service.admin.dto.StaffMemberDTO;

@RestController
@RequestMapping("/api/rest/admin")
@CrossOrigin(origins = {"http://localhost:4300"})
public class StaffMemberWebService {
	

	private static final Logger LOG = LoggerFactory.getLogger(StaffMemberWebService.class);
	
	@Autowired
	private StaffMemberService staffMemberService;


	@GetMapping("/getListOfStaffMembers")
	public ResponseEntity<List <StaffMemberDTO>> getListOfStaffMembers() {
		List<StaffMemberDTO> staffMemberListResp = staffMemberService.retrieveAllStaffMembers();
		return new ResponseEntity<> (staffMemberListResp, HttpStatus.OK);
		
	}	
	
	
}

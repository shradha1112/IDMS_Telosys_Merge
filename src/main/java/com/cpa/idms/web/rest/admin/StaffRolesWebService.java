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
import com.cpa.idms.service.admin.IDMSBaseService;
import com.cpa.idms.service.admin.StaffRoleService;
import com.cpa.idms.service.admin.dto.StaffRolesDTO;
import com.cpa.idms.util.FormatConverterUtils;

/**
 * REST Interface to access Staff Roles information
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/rest/admin")
@CrossOrigin(origins = { "http://localhost:4300" })
public class StaffRolesWebService {

	private static final Logger LOG = (Logger) LoggerFactory.getLogger(StaffRolesWebService.class);
	
	@Autowired
	private  StaffRoleService staffRolesService;

	@Autowired
	private IDMSBaseService idmsBaseService;

	
	
	@PostMapping("/createStaffRoles")
	public ResponseEntity<StaffRolesDTO> insertStaffRoles(@RequestBody StaffRolesDTO staffRolesDTO){
		try{
				if(staffRolesDTO!=null) {				
					StaffMember loginUser = idmsBaseService.currentUser();
					FormatConverterUtils.setInitialDefaultValues(staffRolesDTO, loginUser);
				
					StaffRolesDTO datastaffRolesDTO = staffRolesService.insertStaffRoles(staffRolesDTO);
					return new ResponseEntity<> (datastaffRolesDTO, HttpStatus.OK);
			}
		}catch (Exception e) {
			LOG.error("Error while inserting StaffRoles {}",e);
		}
		
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
	}

	@GetMapping("/getAllStaffRoles")
	public ResponseEntity<List<StaffRolesDTO>> getAllStaffRoles() {
		List<StaffRolesDTO> staffRolesDTOResp;
		try {
			staffRolesDTOResp = staffRolesService.retrieveAllStaffRoles();
			return new ResponseEntity<> (staffRolesDTOResp, HttpStatus.OK);

		} catch (IdmsBaseException e) {
			LOG.error("Error while retrieving all  StaffRoles {}",e);
		}
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
	}

	@GetMapping("/getStaffRolesById")
		public ResponseEntity<StaffRolesDTO> getStaffRolesById(@RequestParam("id") Long staffRoleId) {
		StaffRolesDTO staffRolesDTO;
		try {
			staffRolesDTO =  staffRolesService.retrieveStaffRolesByStaffId(staffRoleId);
			return new ResponseEntity<> (staffRolesDTO, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("Error while retrieving By StaffRoles ID {}",e);
		}
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers , HttpStatus.NOT_IMPLEMENTED);
	}


	
	@PutMapping("/updateStaffRoles")
	public ResponseEntity<StaffRolesDTO> updateStaffRoles(@RequestBody StaffRolesDTO staffRolesDTO){
		try{
			  if(staffRolesDTO!=null) {				
				StaffMember loginUser = idmsBaseService.currentUser();
				FormatConverterUtils.setInitialDefaultValues(staffRolesDTO, loginUser);
				StaffRolesDTO datastaffRolesDTO = staffRolesService.updateStaffRoles(staffRolesDTO);
				return new ResponseEntity<> (datastaffRolesDTO, HttpStatus.OK);
			}
		}catch (Exception e) {
			LOG.error("Error while updating StaffRoles {}",e);
		}
		
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
	}


	@DeleteMapping("/removeStaffRolesById")
	public ResponseEntity<Void> deleteStaffRolesById(@Valid @RequestParam("id") Long staffRoleId){
	HttpHeaders headers= new HttpHeaders();
		try {
			Boolean flag = staffRolesService.deleteById(staffRoleId);
			if(flag)
				return new ResponseEntity<> (headers, HttpStatus.OK);
			else
				return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
		}catch (Exception e) {
			LOG.error("Error while deleting By StaffRoles ID {}",e);
		}
		
		return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
	
	}

	

}

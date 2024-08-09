package com.cpa.idms.web.rest.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.idms.backend.dao.admin.entities.StaffMember;
import com.cpa.idms.security.SecurityContextService;
import com.cpa.idms.service.admin.IDMSBaseService;
import com.cpa.idms.service.admin.StaffRoleService;
import com.cpa.idms.service.admin.dto.StaffRolesDTO;


/**
 * REST Interface to access Staff Member 
 * information
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/rest/admin")
@CrossOrigin(origins = {"http://localhost:4300"})
public class ProfileWebService {
	
	
	@Autowired
	private SecurityContextService securityContextService;
	
	@Autowired
	private StaffRoleService staffRolesService;
	
	@Autowired
	private IDMSBaseService ehrBaseService;
	
	@GetMapping("/isAdmin")
	public ResponseEntity<Boolean> isAdmin(HttpServletRequest request) {
		try {
			StaffRolesDTO role= staffRolesService.retrieveStaffRolesByStaffId(securityContextService.currentUser().getStaffId());
			if(role!=null) {
				if(role.getAuthority().contentEquals("ROLE_ADMIN")) 
					return new ResponseEntity<>(true, HttpStatus.OK);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/profile")
	public ResponseEntity<StaffMember> getProfile(HttpServletRequest request) {
		StaffMember staff = ehrBaseService.currentUser();
		return new ResponseEntity<>(staff, HttpStatus.OK);
	}
}

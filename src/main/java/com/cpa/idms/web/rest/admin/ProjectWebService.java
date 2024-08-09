package com.cpa.idms.web.rest.admin;

import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.cpa.idms.service.admin.ProjectService;
import com.cpa.idms.service.admin.dto.ProjectDTO;
import com.cpa.idms.util.FormatConverterUtils;

@RestController
@RequestMapping("/api/rest")
@CrossOrigin(origins = {"http://localhost:4300"})
public class ProjectWebService {
	
	private static final Logger LOG = LoggerFactory.getLogger(ProjectWebService.class);

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private IDMSBaseService idmsBaseService;


	@GetMapping("admin/getListOfProjects")
	public ResponseEntity<List <ProjectDTO>> getListOfProjects() {
		List<ProjectDTO> projectListResp = projectService.retrieveAllProjects();
		System.out.println("in project webbbb serviceeee"+projectListResp);
		return new ResponseEntity<> (projectListResp, HttpStatus.OK);
		
	}	
	
	@PostMapping("/createProject")
	public ResponseEntity<ProjectDTO> insertProject(@RequestBody ProjectDTO projectDTO){
		try{
				if(projectDTO!=null) {				
					StaffMember loginUser = idmsBaseService.currentUser();
					FormatConverterUtils.setInitialDefaultValues(projectDTO, loginUser);
				
					ProjectDTO dataprojectDTO = projectService.insertProject(projectDTO);
					return new ResponseEntity<> (dataprojectDTO, HttpStatus.OK);
			}
		}catch (Exception e) {
			LOG.error("Error while inserting Project {}",e);
		}
		
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
	}
	
	@GetMapping("/getProjectById")
	public ResponseEntity<ProjectDTO> getProjectById(@RequestParam("id") Long projectId) {
	ProjectDTO projectDTO;
		try {
			projectDTO =  projectService.retrieveProjectById( projectId);
			return new ResponseEntity<> (projectDTO, HttpStatus.OK);
		} catch (IdmsBaseException e) {
			LOG.error("Error while retrieving By Project ID {}",e);
		}
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers , HttpStatus.NOT_IMPLEMENTED);
	}


	
	@PutMapping("/updateProject")
	public ResponseEntity<ProjectDTO> updateProject(@RequestBody ProjectDTO projectDTO){
		try{
			  if(projectDTO!=null) {				
				StaffMember loginUser = idmsBaseService.currentUser();
				FormatConverterUtils.setInitialDefaultValues(projectDTO, loginUser);
				ProjectDTO dataprojectDTO = projectService.updateProject(projectDTO);
				return new ResponseEntity<> (dataprojectDTO, HttpStatus.OK);
			}
		}catch (Exception e) {
			LOG.error("Error while updating Project {}",e);
		}
		
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
	}


	@DeleteMapping("/removeProjectById")
	public ResponseEntity<Void> deleteProjectById(@Valid @RequestParam("id") Long projectId){
	HttpHeaders headers= new HttpHeaders();
		try {
			Boolean flag = projectService.deleteById(projectId);
			if(flag)
				return new ResponseEntity<> (headers, HttpStatus.OK);
			else
				return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
		}catch (Exception e) {
			LOG.error("Error while deleting By Project ID {}",e);
		}
		
		return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
	
	}

	
	
}

/*
 * Created on 2021-05-06 ( Date ISO 2021-05-06 - Time 17:00:24 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.cpa.idms.web.rest.admin;


import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import com.cpa.idms.backend.dao.admin.entities.StaffMember;
import com.cpa.idms.backend.dao.exception.entities.IdmsBaseException;
import com.cpa.idms.service.admin.IDMSBaseService;
import com.cpa.idms.service.admin.ProjectDocumentsVersionService;
import com.cpa.idms.service.admin.dto.ProjectDocumentsVersionDTO;
import com.cpa.idms.util.FormatConverterUtils;



/**
 * Rest controller which produce Hal+json content (including hateoas metadata).
 * @author Rajol version 3.0.0
 */
@RestController
@RequestMapping("/api/rest")
@CrossOrigin(origins = { "http://localhost:4300" })
public class ProjectDocumentsVersionWebService {

	private static final Logger LOG = LoggerFactory.getLogger(ProjectDocumentsVersionWebService.class);


	@Autowired
	private  ProjectDocumentsVersionService projectDocumentsVersionService;

	@Autowired
	private IDMSBaseService idmsBaseService;

	
	@PostMapping("/createProjectDocumentsVersion")
	public ResponseEntity<ProjectDocumentsVersionDTO> insertProjectDocumentsVersion(@RequestBody ProjectDocumentsVersionDTO projectDocumentsVersionDTO){
		try{
				if(projectDocumentsVersionDTO!=null) {				
					StaffMember loginUser = idmsBaseService.currentUser();
					FormatConverterUtils.setInitialDefaultValues(projectDocumentsVersionDTO, loginUser);
				
					ProjectDocumentsVersionDTO dataprojectDocumentsVersionDTO = projectDocumentsVersionService.insertProjectDocumentsVersion(projectDocumentsVersionDTO);
					return new ResponseEntity<> (dataprojectDocumentsVersionDTO, HttpStatus.OK);
			}
		}catch (Exception e) {
			LOG.error("Error while inserting ProjectDocumentsVersion {}",e);
		}
		
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
	}

	@GetMapping("/getAllProjectDocumentsVersion")
	public ResponseEntity<List<ProjectDocumentsVersionDTO>> getAllProjectDocumentsVersion() {
		List<ProjectDocumentsVersionDTO> projectDocumentsVersionDTOResp;
		try {
			projectDocumentsVersionDTOResp = projectDocumentsVersionService.retrieveAllProjectDocumentsVersion();
			return new ResponseEntity<> (projectDocumentsVersionDTOResp, HttpStatus.OK);

		} catch (IdmsBaseException e) {
			LOG.error("Error while retrieving all  ProjectDocumentsVersion {}",e);
		}
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
	}

		@GetMapping("/getProjectDocumentsVersionById")
	public ResponseEntity<ProjectDocumentsVersionDTO> getProjectDocumentsVersionById(@RequestParam("id") Long projectDocumentsVersionId) {
	ProjectDocumentsVersionDTO projectDocumentsVersionDTO;
		try {
			projectDocumentsVersionDTO =  projectDocumentsVersionService.retrieveProjectDocumentsVersionById( projectDocumentsVersionId);
			return new ResponseEntity<> (projectDocumentsVersionDTO, HttpStatus.OK);
		} catch (IdmsBaseException e) {
			LOG.error("Error while retrieving By ProjectDocumentsVersion ID {}",e);
		}
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers , HttpStatus.NOT_IMPLEMENTED);
	}


	
	@PutMapping("/updateProjectDocumentsVersion")
	public ResponseEntity<ProjectDocumentsVersionDTO> updateProjectDocumentsVersion(@RequestBody ProjectDocumentsVersionDTO projectDocumentsVersionDTO){
		try{
			  if(projectDocumentsVersionDTO!=null) {				
				StaffMember loginUser = idmsBaseService.currentUser();
				FormatConverterUtils.setInitialDefaultValues(projectDocumentsVersionDTO, loginUser);
				ProjectDocumentsVersionDTO dataprojectDocumentsVersionDTO = projectDocumentsVersionService.updateProjectDocumentsVersion(projectDocumentsVersionDTO);
				return new ResponseEntity<> (dataprojectDocumentsVersionDTO, HttpStatus.OK);
			}
		}catch (Exception e) {
			LOG.error("Error while updating ProjectDocumentsVersion {}",e);
		}
		
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
	}


	@DeleteMapping("/removeProjectDocumentsVersionById")
	public ResponseEntity<Void> deleteProjectDocumentsVersionById(@Valid @RequestParam("id") Long projectDocumentsVersionId){
	HttpHeaders headers= new HttpHeaders();
		try {
			Boolean flag = projectDocumentsVersionService.deleteById(projectDocumentsVersionId);
			if(flag)
				return new ResponseEntity<> (headers, HttpStatus.OK);
			else
				return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
		}catch (Exception e) {
			LOG.error("Error while deleting By ProjectDocumentsVersion ID {}",e);
		}
		
		return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
	
	}

}











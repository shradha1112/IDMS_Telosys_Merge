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
import com.cpa.idms.backend.dao.admin.entities.Workflow;
import com.cpa.idms.backend.dao.admin.entities.WorkflowApprovalDetails;
import com.cpa.idms.backend.dao.exception.entities.IdmsBaseException;
import com.cpa.idms.service.admin.IDMSBaseService;
import com.cpa.idms.service.admin.WorkflowDocumentDetailsService;
import com.cpa.idms.service.admin.WorkflowService;
import com.cpa.idms.service.admin.dto.DepartmentDTO;
import com.cpa.idms.service.admin.dto.WorkflowApprovalDetailsDTO;
import com.cpa.idms.service.admin.dto.WorkflowDTO;
import com.cpa.idms.util.FormatConverterUtils;

@RestController
@RequestMapping("/api/rest/workflow")
@CrossOrigin(origins = { "http://localhost:4300" })
public class WorkflowWebService {
	
	private static final Logger LOG = LoggerFactory.getLogger(WorkflowWebService.class);


	@Autowired
	private WorkflowService workflowService;
	
	@Autowired
	private IDMSBaseService idmsBaseService;
	
	

	@PostMapping("/uploadDocument")
	public ResponseEntity<Void> uploadDocument(@RequestBody WorkflowDTO workflow) {
		try {
			Workflow docObj = workflowService.uploadDocument(workflow);
			if (docObj != null) {
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@GetMapping("/getListOfDocuments")
	public ResponseEntity<List<WorkflowDTO>> getListOfDocuments() {
		try {
			List<WorkflowDTO> workflowListResp = workflowService.retrieveAllDocuments();
			if (workflowListResp != null) {
				return new ResponseEntity<>(workflowListResp, HttpStatus.OK);
			}
		}catch (Exception e) {
			
		}
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getPendingDocuments")
	public ResponseEntity<List<WorkflowDTO>> getPendingDocuments() {
		try {
			List<WorkflowDTO> workflowListResp = workflowService.getApprovalPendingDocuments();
			if (workflowListResp != null) {
				return new ResponseEntity<>(workflowListResp, HttpStatus.OK);
			}
		}catch (Exception e) {
			
		}
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);

	}
	
	@GetMapping("/getWorkflowDetailsById")
	public ResponseEntity<WorkflowDTO> getWorkflowDetailsById(@RequestParam("id") Long workflowId) {
		WorkflowDTO workflowDetailsDTO;
		try {
			workflowDetailsDTO =  workflowService.retrieveWorkflowDetailsById( workflowId);
			return new ResponseEntity<> (workflowDetailsDTO, HttpStatus.OK);
		} catch (IdmsBaseException e) {
			LOG.error("Error while retrieving By WorkflowDetails ID {}",e);
		}
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers , HttpStatus.NOT_IMPLEMENTED);
	}


	
	@PutMapping("/updateWorkflowDetails")
	public ResponseEntity<WorkflowDTO> updateWorkflowDetails(@RequestBody WorkflowDTO workflowDetailsDTO){
		try{
			  if(workflowDetailsDTO!=null) {				
				StaffMember loginUser = idmsBaseService.currentUser();
				FormatConverterUtils.setInitialDefaultValues(workflowDetailsDTO, loginUser);
				WorkflowDTO dataworkflowDetailsDTO = workflowService.updateWorkflowDetails(workflowDetailsDTO);
				return new ResponseEntity<> (dataworkflowDetailsDTO, HttpStatus.OK);
			}
		}catch (Exception e) {
			LOG.error("Error while updating WorkflowDetails {}",e);
		}
		
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
	}


	@DeleteMapping("/removeWorkflowDetailsById")
	public ResponseEntity<Void> deleteWorkflowDetailsById(@Valid @RequestParam("id") Long workflowId){
	HttpHeaders headers= new HttpHeaders();
		try {
			Boolean flag = workflowService.deleteById(workflowId);
			if(flag)
				return new ResponseEntity<> (headers, HttpStatus.OK);
			else
				return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
		}catch (Exception e) {
			LOG.error("Error while deleting By WorkflowDetails ID {}",e);
		}
		
		return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
	
	}

	
	
}

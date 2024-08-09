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
import com.cpa.idms.backend.dao.admin.entities.WorkflowApprovalDetails;
import com.cpa.idms.backend.dao.exception.entities.IdmsBaseException;
import com.cpa.idms.service.admin.IDMSBaseService;
import com.cpa.idms.service.admin.WorkflowDocumentDetailsService;
import com.cpa.idms.service.admin.dto.WorkflowApprovalDetailsDTO;
import com.cpa.idms.util.FormatConverterUtils;

@RestController
@RequestMapping("/api/rest/approver")
@CrossOrigin(origins = {"http://localhost:4300"})
public class WorkflowApprovalWebService {
	
	private static final Logger LOG = LoggerFactory.getLogger(WorkflowApprovalWebService.class);


	
	@Autowired
	private WorkflowDocumentDetailsService documentService;
	
	@Autowired
	private IDMSBaseService idmsBaseService;

	
	@PostMapping("/addDocumentStatus")
	public ResponseEntity<WorkflowApprovalDetails> insertDocumentStatus(@RequestBody WorkflowApprovalDetailsDTO statusToInsertDTO){
		try {
			WorkflowApprovalDetails appvrObj = documentService.insertDocumentStatus(statusToInsertDTO);
			if(appvrObj != null) {
				return new ResponseEntity<>(appvrObj,HttpStatus.OK);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers,HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/getAllWorkflowApprovalDetails")
	public ResponseEntity<List<WorkflowApprovalDetailsDTO>> getAllWorkflowApprovalDetails() {
		List<WorkflowApprovalDetailsDTO> workflowApprovalDetailsDTOResp;
		try {
			workflowApprovalDetailsDTOResp = documentService.retrieveAllWorkflowApprovalDetails();
			return new ResponseEntity<> (workflowApprovalDetailsDTOResp, HttpStatus.OK);

		} catch (IdmsBaseException e) {
			LOG.error("Error while retrieving all  WorkflowApprovalDetails {}",e);
		}
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
	}

	@GetMapping("/getWorkflowApprovalDetailsById")
	public ResponseEntity<WorkflowApprovalDetailsDTO> getWorkflowApprovalDetailsById(@RequestParam("id") Long approvalId) {
	WorkflowApprovalDetailsDTO workflowApprovalDetailsDTO;
		try {
			workflowApprovalDetailsDTO =  documentService.retrieveWorkflowApprovalDetailsById( approvalId);
			return new ResponseEntity<> (workflowApprovalDetailsDTO, HttpStatus.OK);
		} catch (IdmsBaseException e) {
			LOG.error("Error while retrieving By WorkflowApprovalDetails ID {}",e);
		}
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers , HttpStatus.NOT_IMPLEMENTED);
	}


	
	@PutMapping("/updateWorkflowApprovalDetails")
	public ResponseEntity<WorkflowApprovalDetailsDTO> updateWorkflowApprovalDetails(@RequestBody WorkflowApprovalDetailsDTO workflowApprovalDetailsDTO){
		try{
			  if(workflowApprovalDetailsDTO!=null) {				
				StaffMember loginUser = idmsBaseService.currentUser();
				FormatConverterUtils.setInitialDefaultValues(workflowApprovalDetailsDTO, loginUser);
				WorkflowApprovalDetailsDTO dataworkflowApprovalDetailsDTO = documentService.updateWorkflowApprovalDetails(workflowApprovalDetailsDTO);
				return new ResponseEntity<> (dataworkflowApprovalDetailsDTO, HttpStatus.OK);
			}
		}catch (Exception e) {
			LOG.error("Error while updating WorkflowApprovalDetails {}",e);
		}
		
		HttpHeaders headers= new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
	}


	@DeleteMapping("/removeWorkflowApprovalDetailsById")
	public ResponseEntity<Void> deleteWorkflowApprovalDetailsById(@Valid @RequestParam("id") Long approvalId){
	HttpHeaders headers= new HttpHeaders();
		try {
			Boolean flag = documentService.deleteById(approvalId);
			if(flag)
				return new ResponseEntity<> (headers, HttpStatus.OK);
			else
				return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
		}catch (Exception e) {
			LOG.error("Error while deleting By WorkflowApprovalDetails ID {}",e);
		}
		
		return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
	
	}
}

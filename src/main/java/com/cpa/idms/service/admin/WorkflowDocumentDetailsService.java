package com.cpa.idms.service.admin;

import java.util.List;

import com.cpa.idms.backend.dao.admin.entities.WorkflowApprovalDetails;
import com.cpa.idms.backend.dao.exception.entities.IdmsBaseException;
import com.cpa.idms.service.admin.dto.WorkflowApprovalDetailsDTO;

public interface WorkflowDocumentDetailsService {

	WorkflowApprovalDetails insertDocumentStatus(WorkflowApprovalDetailsDTO approvalDetailsDTO);
  	WorkflowApprovalDetailsDTO retrieveWorkflowApprovalDetailsById(Long approvalId) throws IdmsBaseException;
	List<WorkflowApprovalDetailsDTO> retrieveAllWorkflowApprovalDetails() throws IdmsBaseException;
	WorkflowApprovalDetailsDTO updateWorkflowApprovalDetails(WorkflowApprovalDetailsDTO workflowApprovalDetailsDTOUpdate) throws IdmsBaseException;
	Boolean deleteById(Long approvalId) throws IdmsBaseException;
	
}

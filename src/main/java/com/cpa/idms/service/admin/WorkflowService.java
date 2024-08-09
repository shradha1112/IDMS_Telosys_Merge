package com.cpa.idms.service.admin;

import java.util.List;

import com.cpa.idms.backend.dao.admin.entities.Workflow;
import com.cpa.idms.backend.dao.exception.entities.IdmsBaseException;
import com.cpa.idms.service.admin.dto.WorkflowDTO;

public interface WorkflowService {

	Workflow uploadDocument(WorkflowDTO workflowDTO);
	
	List<WorkflowDTO> retrieveAllDocuments();
	
	List<WorkflowDTO> getApprovalPendingDocuments();
	
	WorkflowDTO retrieveWorkflowDetailsById(Long workflowId) throws IdmsBaseException;
  	
	WorkflowDTO updateWorkflowDetails(WorkflowDTO workflowDetailsDTOUpdate) throws IdmsBaseException;
	
	Boolean deleteById(Long workflowId) throws IdmsBaseException;
}

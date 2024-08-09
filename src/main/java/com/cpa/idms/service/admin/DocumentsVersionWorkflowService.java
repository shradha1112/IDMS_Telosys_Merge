/*
 * Created on 2021-05-06 ( Date ISO 2021-05-06 - Time 17:00:22 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.cpa.idms.service.admin;

import com.cpa.idms.backend.dao.exception.entities.IdmsBaseException;
import com.cpa.idms.service.admin.dto.DocumentsVersionWorkflowDTO;

import java.util.List;


public interface DocumentsVersionWorkflowService {


	DocumentsVersionWorkflowDTO insertDocumentsVersionWorkflow(DocumentsVersionWorkflowDTO documentsVersionWorkflowDTOinsert) throws IdmsBaseException;
  	DocumentsVersionWorkflowDTO retrieveDocumentsVersionWorkflowById(Long documentsVersionWorkflowId) throws IdmsBaseException;
	List<DocumentsVersionWorkflowDTO> retrieveAllDocumentsVersionWorkflow() throws IdmsBaseException;
	DocumentsVersionWorkflowDTO updateDocumentsVersionWorkflow(DocumentsVersionWorkflowDTO documentsVersionWorkflowDTOUpdate) throws IdmsBaseException;
	  	Boolean deleteById(Long documentsVersionWorkflowId) throws IdmsBaseException;
	}

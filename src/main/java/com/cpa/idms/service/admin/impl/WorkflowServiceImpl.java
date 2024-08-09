package com.cpa.idms.service.admin.impl;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.idms.backend.dao.admin.WorkflowDocumentDetailsRepository;
import com.cpa.idms.backend.dao.admin.WorkflowRepository;
import com.cpa.idms.backend.dao.admin.entities.Department;
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
import com.cpa.idms.service.admin.dto.mapper.WorkflowApprovalDetailsMapper;
import com.cpa.idms.service.admin.dto.mapper.WorkflowMapper;
import com.cpa.idms.util.FormatConverterUtils;

@Service
public class WorkflowServiceImpl implements WorkflowService{
	
	private static final Logger LOG = LoggerFactory.getLogger(WorkflowServiceImpl.class);


	
	@Autowired
	private WorkflowMapper workflowMapper;
	
	@Autowired
	private IDMSBaseService idmsBaseService;
	
	@Autowired
	private WorkflowRepository workflowRepo;

	@Override
	public Workflow uploadDocument(WorkflowDTO workflowDTO) {
		try {
			if(workflowDTO != null) {
				Workflow insertedData;
				Workflow documentDetails = workflowMapper.workflowToEntity(workflowDTO);
				insertedData = workflowRepo.save(documentDetails);
				
				return insertedData;
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

	@Override
	public List<WorkflowDTO> retrieveAllDocuments() {
			try {
				
				StaffMember staffObj = idmsBaseService.currentUser();
				List<Workflow> workflowList = workflowRepo.findAllDocuments(staffObj.getFirstName());
				return (workflowList != null) ? workflowMapper.entityListToworkflowDTOList(workflowList) : null;
			}
			catch (Exception e){
				
			}
			return Collections.emptyList();
		
	}
	
	@Override
	public List<WorkflowDTO> getApprovalPendingDocuments() {
		try {
			StaffMember staffObj = idmsBaseService.currentUser();
			List<Workflow> workflowList = workflowRepo.findAllPendingDoc(staffObj.getFirstName());
			return (workflowList != null) ? workflowMapper.entityListToworkflowDTOList(workflowList) : null;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return Collections.emptyList();
	}
	
	@Override
	public WorkflowDTO retrieveWorkflowDetailsById(Long workflowId) throws IdmsBaseException{
		try {
		if(workflowId != null) {
			Workflow workflowDetails = workflowRepo.findOne(workflowId);
			return (workflowDetails != null) ? workflowMapper.entityToWorkflowDTO(workflowDetails) : null;
		}
		}catch (Exception e) {
			LOG.error("Error Message",e);
		}
		return null;

	}
	
	@Override
	public 	WorkflowDTO updateWorkflowDetails(WorkflowDTO workflowDetailsDTOUpdate) throws IdmsBaseException{
	try{
		if(workflowDetailsDTOUpdate !=null){
			Workflow workflowDetails = workflowMapper.workflowToEntity(workflowDetailsDTOUpdate);
			Workflow UpdatedworkflowDetails = workflowRepo.saveAndFlush(workflowDetails);
				return (UpdatedworkflowDetails != null) ? workflowMapper.entityToWorkflowDTO(UpdatedworkflowDetails) : null;
					
		}
	}
	catch (Exception e){
			LOG.error("Error while updating WorkflowDetails {} ", e);
		}
	return null;
	}


	@Override
		public Boolean deleteById(Long workflowId) throws IdmsBaseException{
	try {
		Workflow workflowDetails = workflowRepo.findOne(workflowId);
			if (workflowDetails != null) {
				StaffMember loginUser = idmsBaseService.currentUser();
				FormatConverterUtils.setInitialDeleteValues(workflowDetails, loginUser);
				workflowRepo.saveAndFlush(workflowDetails);
				return true;
			}
		} catch (Exception e) {
			LOG.error("Error while deleting WorkflowDetails {} ", e);
		}
		return false;


	}
}

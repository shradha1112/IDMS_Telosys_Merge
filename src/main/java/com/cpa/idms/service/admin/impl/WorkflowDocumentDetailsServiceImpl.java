package com.cpa.idms.service.admin.impl;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.idms.backend.dao.admin.WorkflowDocumentDetailsRepository;
import com.cpa.idms.backend.dao.admin.entities.StaffMember;
import com.cpa.idms.backend.dao.admin.entities.WorkflowApprovalDetails;
import com.cpa.idms.backend.dao.exception.entities.IdmsBaseException;
import com.cpa.idms.service.admin.IDMSBaseService;
import com.cpa.idms.service.admin.WorkflowDocumentDetailsService;
import com.cpa.idms.service.admin.dto.WorkflowApprovalDetailsDTO;
import com.cpa.idms.service.admin.dto.mapper.WorkflowApprovalDetailsMapper;
import com.cpa.idms.util.FormatConverterUtils;

@Service
public class WorkflowDocumentDetailsServiceImpl implements WorkflowDocumentDetailsService{
	
	private static final Logger LOG = LoggerFactory.getLogger(WorkflowDocumentDetailsServiceImpl.class);


	
	@Autowired
	private WorkflowApprovalDetailsMapper approvalMapper;
	
	@Autowired
	private WorkflowDocumentDetailsRepository approvalRepo;
	
	@Autowired
	private IDMSBaseService idmsBaseService;
	
	
	
	@Override
	public WorkflowApprovalDetails insertDocumentStatus(WorkflowApprovalDetailsDTO approvalDetailsDTO) {
		try {
			if(approvalDetailsDTO != null) {
				WorkflowApprovalDetails insertedData;
				WorkflowApprovalDetails approvalDetails = approvalMapper.workflowApprovalDetailsToEntity(approvalDetailsDTO);
				insertedData = approvalRepo.save(approvalDetails);
				
				return insertedData;
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
		
	}
	
	
	@Override
	public WorkflowApprovalDetailsDTO retrieveWorkflowApprovalDetailsById(Long approvalId) throws IdmsBaseException{
		try {
			if(approvalId != null) {
				WorkflowApprovalDetails workflowApprovalDetails = approvalRepo.findOne(approvalId);
				return (workflowApprovalDetails != null) ? approvalMapper.entityToWorkflowApprovalDetailsDTO(workflowApprovalDetails) : null;
		}
		}catch (Exception e) {
			LOG.error("Error Message",e);
	}
		return null;
}

	@Override
	public List<WorkflowApprovalDetailsDTO> retrieveAllWorkflowApprovalDetails() throws IdmsBaseException {
		try {
			List<WorkflowApprovalDetails> workflowApprovalDetailsList = approvalRepo.findAll();
			return (workflowApprovalDetailsList != null) ? approvalMapper.entityListToWorkflowApprovalDetailsDTOList(workflowApprovalDetailsList) : null;
		} catch (Exception e) {
			LOG.error("Error message",e);		
		}
		return Collections.emptyList();
}

	@Override
	public 	WorkflowApprovalDetailsDTO updateWorkflowApprovalDetails(WorkflowApprovalDetailsDTO workflowApprovalDetailsDTOUpdate) throws IdmsBaseException{
		try{
			if(workflowApprovalDetailsDTOUpdate !=null){
					WorkflowApprovalDetails workflowApprovalDetails = approvalMapper.workflowApprovalDetailsToEntity(workflowApprovalDetailsDTOUpdate);
					WorkflowApprovalDetails UpdatedworkflowApprovalDetails = approvalRepo.saveAndFlush(workflowApprovalDetails);
					return (UpdatedworkflowApprovalDetails != null) ? approvalMapper.entityToWorkflowApprovalDetailsDTO(UpdatedworkflowApprovalDetails) : null;
				
			}
		}
		catch (Exception e){
			LOG.error("Error while updating WorkflowApprovalDetails {} ", e);
		}	
		return null;
	}


@Override
	public Boolean deleteById(Long approvalId) throws IdmsBaseException{
try {
		WorkflowApprovalDetails workflowApprovalDetails = approvalRepo.findOne(approvalId);
		if (workflowApprovalDetails != null) {
			StaffMember loginUser = idmsBaseService.currentUser();
			FormatConverterUtils.setInitialDeleteValues(workflowApprovalDetails, loginUser);
			approvalRepo.saveAndFlush(workflowApprovalDetails);
			return true;
		}
	} catch (Exception e) {
		LOG.error("Error while deleting WorkflowApprovalDetails {} ", e);
	}
	return false;


}
	
	
}

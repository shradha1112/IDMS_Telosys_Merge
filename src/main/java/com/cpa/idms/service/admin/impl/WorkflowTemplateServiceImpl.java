/*
 * Created on 2021-05-06 ( Date ISO 2021-05-06 - Time 17:00:25 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.cpa.idms.service.admin.impl;

import java.util.Collections;
import java.util.List;
import com.cpa.idms.backend.dao.admin.entities.WorkflowTemplate;
import com.cpa.idms.service.admin.WorkflowTemplateService;
import com.cpa.idms.service.admin.dto.WorkflowTemplateDTO;
import com.cpa.idms.service.admin.dto.mapper.WorkflowTemplateMapper;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.cpa.idms.backend.dao.admin.WorkflowTemplateRepository;
import com.cpa.idms.backend.dao.admin.entities.StaffMember;
import com.cpa.idms.backend.dao.exception.entities.IdmsBaseException;
import com.cpa.idms.service.admin.IDMSBaseService;
import com.cpa.idms.util.FormatConverterUtils;
import org.springframework.stereotype.Service;
/**
 * Service implementation for WorkflowTemplate.
 * @author Rajol version 3.0.0
 */
@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

private static final Logger LOG = Logger.getLogger(WorkflowTemplateServiceImpl.class);

	@Autowired
	private WorkflowTemplateRepository workflowTemplateRepository;

	@Autowired
	private WorkflowTemplateMapper workflowTemplateMapper;

	@Autowired
	private IDMSBaseService idmsBaseService;

	
		
	@Override
	public WorkflowTemplateDTO insertWorkflowTemplate(WorkflowTemplateDTO workflowTemplateDTOinsert) throws IdmsBaseException{
	try {
			if (workflowTemplateDTOinsert != null) {
				WorkflowTemplate workflowTemplate = workflowTemplateMapper.convertWorkflowTemplateDTOToEntity(workflowTemplateDTOinsert);
				WorkflowTemplate insertedworkflowTemplate = workflowTemplateRepository.save(workflowTemplate);

				return (insertedworkflowTemplate != null) ? workflowTemplateMapper.convertEntityToWorkflowTemplateDTO(insertedworkflowTemplate) : null;
			}
		} catch (Exception e) {
			LOG.error("Error while inserting WorkflowTemplate {} ", e);
		}
		return null;
	}

	@Override
		public WorkflowTemplateDTO retrieveWorkflowTemplateById(Long workflowTemplateId) throws IdmsBaseException{
	try {
			if(workflowTemplateId != null) {
				WorkflowTemplate workflowTemplate = workflowTemplateRepository.findOne(workflowTemplateId);
				return (workflowTemplate != null) ? workflowTemplateMapper.convertEntityToWorkflowTemplateDTO(workflowTemplate) : null;
			}
		}catch (Exception e) {
				LOG.error("Error Message",e);
		}
		return null;
	}

	@Override
	public List<WorkflowTemplateDTO> retrieveAllWorkflowTemplate() throws IdmsBaseException {
	try {
			List<WorkflowTemplate> workflowTemplateList = workflowTemplateRepository.findAll();
			return (workflowTemplateList != null) ? workflowTemplateMapper.entityListToWorkflowTemplateDTOList(workflowTemplateList) : null;
		} catch (Exception e) {
		LOG.error("Error message",e);		
		}
		return Collections.emptyList();
	}

	@Override
	public 	WorkflowTemplateDTO updateWorkflowTemplate(WorkflowTemplateDTO workflowTemplateDTOUpdate) throws IdmsBaseException{
	try{
		if(workflowTemplateDTOUpdate !=null){
						WorkflowTemplate workflowTemplate = workflowTemplateMapper.convertWorkflowTemplateDTOToEntity(workflowTemplateDTOUpdate);
				WorkflowTemplate UpdatedworkflowTemplate = workflowTemplateRepository.saveAndFlush(workflowTemplate);
				return (UpdatedworkflowTemplate != null) ? workflowTemplateMapper.convertEntityToWorkflowTemplateDTO(UpdatedworkflowTemplate) : null;
					
		}
	}
	catch (Exception e){
			LOG.error("Error while updating WorkflowTemplate {} ", e);
		}
	return null;
	}


	@Override
		public Boolean deleteById(Long workflowTemplateId) throws IdmsBaseException{
	try {
			WorkflowTemplate workflowTemplate = workflowTemplateRepository.findOne(workflowTemplateId);
			if (workflowTemplate != null) {
				StaffMember loginUser = idmsBaseService.currentUser();
				FormatConverterUtils.setInitialDeleteValues(workflowTemplate, loginUser);
				workflowTemplateRepository.saveAndFlush(workflowTemplate);
				return true;
			}
		} catch (Exception e) {
			LOG.error("Error while deleting WorkflowTemplate {} ", e);
		}
		return false;


	}



}












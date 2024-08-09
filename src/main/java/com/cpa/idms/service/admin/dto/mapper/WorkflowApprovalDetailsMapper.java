package com.cpa.idms.service.admin.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cpa.idms.backend.dao.admin.entities.*;
import com.cpa.idms.service.admin.dto.*;

@Mapper(componentModel = "spring",
imports = {com.cpa.idms.util.FormatConverterUtils.class})
public abstract class WorkflowApprovalDetailsMapper {
	
	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()))")
	public abstract WorkflowApprovalDetailsDTO entityToWorkflowApprovalDetailsDTO(WorkflowApprovalDetails entity);

	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()))")
	public abstract WorkflowApprovalDetails workflowApprovalDetailsToEntity(WorkflowApprovalDetailsDTO dto);

	public abstract List<WorkflowApprovalDetailsDTO> entityListToWorkflowApprovalDetailsDTOList(List<WorkflowApprovalDetails> entities);

}

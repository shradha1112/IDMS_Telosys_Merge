package com.cpa.idms.service.admin.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cpa.idms.backend.dao.admin.entities.*;
import com.cpa.idms.service.admin.dto.*;

@Mapper(componentModel = "spring",
imports = {com.cpa.idms.util.FormatConverterUtils.class})
public abstract class SubDepartmentMapper {

	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()))")
	public abstract SubDepartmentDTO entityToSubDepartmentDTO(SubDepartment entity);

	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()))")
	public abstract SubDepartment subDepartmentDTOToEntity(SubDepartmentDTO dto);

	public abstract List<SubDepartmentDTO> entityListTosubDepartmentDTOList(List<SubDepartment> entities);
}

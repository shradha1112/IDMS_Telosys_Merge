package com.cpa.idms.service.admin.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cpa.idms.backend.dao.admin.entities.Department;
import com.cpa.idms.backend.dao.admin.entities.StaffMember;
import com.cpa.idms.service.admin.dto.DepartmentDTO;

@Mapper(componentModel = "spring",
imports = {com.cpa.idms.util.FormatConverterUtils.class})
public abstract class DepartmentMapper {

	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()))")
	public abstract DepartmentDTO entityToDepartmentDTO(Department entity);

	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()))")
	public abstract Department departmentDTOToEntity(DepartmentDTO dto);

	public abstract List<DepartmentDTO> entityListTodepartmentDTOList(List<Department> entities);
}

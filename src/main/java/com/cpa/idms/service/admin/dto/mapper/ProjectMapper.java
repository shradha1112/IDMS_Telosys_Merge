package com.cpa.idms.service.admin.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cpa.idms.backend.dao.admin.entities.DocumentCategory;
import com.cpa.idms.backend.dao.admin.entities.Project;
import com.cpa.idms.service.admin.dto.DocumentCategoryDTO;
import com.cpa.idms.service.admin.dto.ProjectDTO;

@Mapper(componentModel = "spring",
imports = {com.cpa.idms.util.FormatConverterUtils.class})
public abstract class ProjectMapper {

	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()))")
	public abstract ProjectDTO entityToProjectDTO(Project entity);

	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()))")
	public abstract Project projectDTOToEntity(ProjectDTO dto);

	public abstract List<ProjectDTO> entityListToprojectDTOList(List<Project> entities);
}

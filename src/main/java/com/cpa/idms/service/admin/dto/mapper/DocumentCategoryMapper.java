package com.cpa.idms.service.admin.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cpa.idms.backend.dao.admin.entities.Department;
import com.cpa.idms.backend.dao.admin.entities.DocumentCategory;
import com.cpa.idms.service.admin.dto.DepartmentDTO;
import com.cpa.idms.service.admin.dto.DocumentCategoryDTO;

@Mapper(componentModel = "spring",
imports = {com.cpa.idms.util.FormatConverterUtils.class})
public abstract class DocumentCategoryMapper {

	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertActiveFlagtoBoolean(entity.getActiveFlag()))")
	public abstract DocumentCategoryDTO entityToDocumentCategoryDTO(DocumentCategory entity);

	@Mapping(target = "activeFlag", expression = "java(FormatConverterUtils.convertBooleantoActiveFlag(dto.getActiveFlag()))")
	public abstract DocumentCategory documentCategoryDTOToEntity(DocumentCategoryDTO dto);

	public abstract List<DocumentCategoryDTO> entityListTodocumentCategoryDTOList(List<DocumentCategory> entities);
}

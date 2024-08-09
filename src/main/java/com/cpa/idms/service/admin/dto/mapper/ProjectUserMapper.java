/*
 * Created on 2021-05-06 ( Date ISO 2021-05-06 - Time 17:00:24 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.cpa.idms.service.admin.dto.mapper;

import java.util.List;

import com.cpa.idms.backend.dao.admin.entities.ProjectUser;
import com.cpa.idms.service.admin.dto.ProjectUserDTO;

import org.mapstruct.Mapper;
/**
 * ProjectUserDTO's Mapper declaration using selma.
 * @author Rajol version 3.0.0
 */
@Mapper(componentModel = "spring")
public abstract class ProjectUserMapper {

	// This will build a fresh new ProjectUserDTO with in infos
		
public abstract  ProjectUserDTO convertEntityToProjectUserDTO(ProjectUser entity);
	
public abstract  ProjectUser  convertProjectUserDTOToEntity( ProjectUserDTO dto);

public abstract List<ProjectUserDTO>  entityListToProjectUserDTOList(List<ProjectUser> entities);
}

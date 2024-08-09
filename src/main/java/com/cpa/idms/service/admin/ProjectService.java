package com.cpa.idms.service.admin;

import java.util.List;

import com.cpa.idms.backend.dao.exception.entities.IdmsBaseException;
import com.cpa.idms.service.admin.dto.ProjectDTO;

public interface ProjectService {

	List<ProjectDTO> retrieveAllProjects();
	ProjectDTO insertProject(ProjectDTO projectDTOinsert) throws IdmsBaseException;
  	ProjectDTO retrieveProjectById(Long projectId) throws IdmsBaseException;
	ProjectDTO updateProject(ProjectDTO projectDTOUpdate) throws IdmsBaseException;
	Boolean deleteById(Long projectId) throws IdmsBaseException;
	

}

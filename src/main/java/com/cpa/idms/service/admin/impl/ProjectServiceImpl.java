package com.cpa.idms.service.admin.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.idms.backend.dao.admin.DepartmentRepository;
import com.cpa.idms.backend.dao.admin.ProjectRepository;
import com.cpa.idms.backend.dao.admin.entities.Department;
import com.cpa.idms.backend.dao.admin.entities.Project;
import com.cpa.idms.backend.dao.admin.entities.StaffMember;
import com.cpa.idms.backend.dao.exception.entities.IdmsBaseException;
import com.cpa.idms.service.admin.DepartmentService;
import com.cpa.idms.service.admin.IDMSBaseService;
import com.cpa.idms.service.admin.ProjectService;
import com.cpa.idms.service.admin.dto.DepartmentDTO;
import com.cpa.idms.service.admin.dto.ProjectDTO;
import com.cpa.idms.service.admin.dto.mapper.DepartmentMapper;
import com.cpa.idms.service.admin.dto.mapper.ProjectMapper;
import com.cpa.idms.util.FormatConverterUtils;


@Service
public class ProjectServiceImpl implements ProjectService {
	private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceImpl.class);
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@Autowired
	private ProjectMapper projectMapper;
	
	@Autowired
	private IDMSBaseService idmsBaseService;
	
	
	@Override
	public List<ProjectDTO> retrieveAllProjects() {
		try {
			System.out.println("In interfaceeee  servicee impl");
			List<Project> projectList = projectRepo.findAllProjects();
			return (projectList != null) ? projectMapper.entityListToprojectDTOList(projectList) : null;
		}
		catch (Exception e){
			LOG.error("Error while retrieving all projects {} ", e);
		}
		return Collections.emptyList();
	}
	
	@Override
	public ProjectDTO insertProject(ProjectDTO projectDTOinsert) throws IdmsBaseException{
	try {
			if (projectDTOinsert != null) {
				Project project = projectMapper.projectDTOToEntity(projectDTOinsert);
				Project insertedproject = projectRepo.save(project);

				return (insertedproject != null) ? projectMapper.entityToProjectDTO(insertedproject) : null;
			}
		} catch (Exception e) {
			LOG.error("Error while inserting Project {} ", e);
		}
		return null;
	}

	@Override
	public ProjectDTO retrieveProjectById(Long projectId) throws IdmsBaseException{
	try {
			if(projectId != null) {
				Project project = projectRepo.findOne(projectId);
				return (project != null) ? projectMapper.entityToProjectDTO(project) : null;
			}
		}catch (Exception e) {
				LOG.error("Error Message",e);
		}
		return null;
	}
	
	@Override
	public 	ProjectDTO updateProject(ProjectDTO projectDTOUpdate) throws IdmsBaseException{
	try{
		if(projectDTOUpdate !=null){
				Project project = projectMapper.projectDTOToEntity(projectDTOUpdate);
				Project Updatedproject = projectRepo.saveAndFlush(project);
				return (Updatedproject != null) ? projectMapper.entityToProjectDTO(Updatedproject) : null;
					
		}
	}
	catch (Exception e){
			LOG.error("Error while updating Project {} ", e);
		}
	return null;
	}


	@Override
	public Boolean deleteById(Long projectId) throws IdmsBaseException{
	try {
			Project project = projectRepo.findOne(projectId);
			if (project != null) {
				StaffMember loginUser = idmsBaseService.currentUser();
				FormatConverterUtils.setInitialDeleteValues(project, loginUser);
				projectRepo.saveAndFlush(project);
				return true;
			}
		} catch (Exception e) {
			LOG.error("Error while deleting Project {} ", e);
		}
		return false;


	}


	
}
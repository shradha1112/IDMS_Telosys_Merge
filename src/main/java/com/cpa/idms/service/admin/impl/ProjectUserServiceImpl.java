/*
 * Created on 2021-05-06 ( Date ISO 2021-05-06 - Time 17:00:24 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.cpa.idms.service.admin.impl;

import java.util.Collections;
import java.util.List;

import com.cpa.idms.backend.dao.admin.ProjectUserRepository;
import com.cpa.idms.backend.dao.admin.entities.ProjectUser;
import com.cpa.idms.service.admin.ProjectUserService;
import com.cpa.idms.service.admin.dto.ProjectUserDTO;
import com.cpa.idms.service.admin.dto.mapper.ProjectUserMapper;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.cpa.idms.backend.dao.admin.entities.StaffMember;
import com.cpa.idms.backend.dao.exception.entities.IdmsBaseException;
import com.cpa.idms.service.admin.IDMSBaseService;
import com.cpa.idms.util.FormatConverterUtils;
import org.springframework.stereotype.Service;
/**
 * Service implementation for ProjectUser.
 * @author Rajol version 3.0.0
 */
@Service
public class ProjectUserServiceImpl implements ProjectUserService {

private static final Logger LOG = Logger.getLogger(ProjectUserServiceImpl.class);

	@Autowired
	private ProjectUserRepository projectUserRepository;

	@Autowired
	private ProjectUserMapper projectUserMapper;

	@Autowired
	private IDMSBaseService idmsBaseService;

	
		
	@Override
	public ProjectUserDTO insertProjectUser(ProjectUserDTO projectUserDTOinsert) throws IdmsBaseException{
	try {
			if (projectUserDTOinsert != null) {
				ProjectUser projectUser = projectUserMapper.convertProjectUserDTOToEntity(projectUserDTOinsert);
				ProjectUser insertedprojectUser = projectUserRepository.save(projectUser);

				return (insertedprojectUser != null) ? projectUserMapper.convertEntityToProjectUserDTO(insertedprojectUser) : null;
			}
		} catch (Exception e) {
			LOG.error("Error while inserting ProjectUser {} ", e);
		}
		return null;
	}

	@Override
		public ProjectUserDTO retrieveProjectUserById(Long projectUserId) throws IdmsBaseException{
	try {
			if(projectUserId != null) {
				ProjectUser projectUser = projectUserRepository.findOne(projectUserId);
				return (projectUser != null) ? projectUserMapper.convertEntityToProjectUserDTO(projectUser) : null;
			}
		}catch (Exception e) {
				LOG.error("Error Message",e);
		}
		return null;
	}

	@Override
	public List<ProjectUserDTO> retrieveAllProjectUser() throws IdmsBaseException {
	try {
			List<ProjectUser> projectUserList = projectUserRepository.findAll();
			return (projectUserList != null) ? projectUserMapper.entityListToProjectUserDTOList(projectUserList) : null;
		} catch (Exception e) {
		LOG.error("Error message",e);		
		}
		return Collections.emptyList();
	}

	@Override
	public 	ProjectUserDTO updateProjectUser(ProjectUserDTO projectUserDTOUpdate) throws IdmsBaseException{
	try{
		if(projectUserDTOUpdate !=null){
						ProjectUser projectUser = projectUserMapper.convertProjectUserDTOToEntity(projectUserDTOUpdate);
				ProjectUser UpdatedprojectUser = projectUserRepository.saveAndFlush(projectUser);
				return (UpdatedprojectUser != null) ? projectUserMapper.convertEntityToProjectUserDTO(UpdatedprojectUser) : null;
					
		}
	}
	catch (Exception e){
			LOG.error("Error while updating ProjectUser {} ", e);
		}
	return null;
	}


	@Override
		public Boolean deleteById(Long projectUserId) throws IdmsBaseException{
	try {
			ProjectUser projectUser = projectUserRepository.findOne(projectUserId);
			if (projectUser != null) {
				StaffMember loginUser = idmsBaseService.currentUser();
				FormatConverterUtils.setInitialDeleteValues(projectUser, loginUser);
				projectUserRepository.saveAndFlush(projectUser);
				return true;
			}
		} catch (Exception e) {
			LOG.error("Error while deleting ProjectUser {} ", e);
		}
		return false;


	}



}












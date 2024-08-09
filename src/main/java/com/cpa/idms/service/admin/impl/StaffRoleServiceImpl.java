package com.cpa.idms.service.admin.impl;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.idms.backend.dao.admin.StaffMemberRepository;
import com.cpa.idms.backend.dao.admin.StaffRolesRepository;
import com.cpa.idms.backend.dao.admin.entities.StaffMember;
import com.cpa.idms.backend.dao.admin.entities.StaffRoles;
import com.cpa.idms.backend.dao.exception.entities.IdmsBaseException;
import com.cpa.idms.service.admin.IDMSBaseService;
import com.cpa.idms.service.admin.StaffRoleService;
import com.cpa.idms.service.admin.dto.StaffRolesDTO;
import com.cpa.idms.service.admin.dto.mapper.StaffRolesMapper;
import com.cpa.idms.util.FormatConverterUtils;


@Service
public class StaffRoleServiceImpl implements StaffRoleService{
	
	private static final Logger LOG = LoggerFactory.getLogger(StaffRoleServiceImpl.class);


	@Autowired
	private StaffRolesRepository staffRolesRepo;

	@Autowired
	private StaffMemberRepository staffMemberRepo;

	@Autowired
	private StaffRolesMapper staffRolesMapper;
	
	@Autowired
	private IDMSBaseService idmsBaseService;
	
	
	
	@Override
	public StaffRolesDTO retrieveStaffRolesByStaffId(Long staffId) {
		StaffRoles staffRoles = staffRolesRepo.findActiveOneByStaffId(staffId);
		return (staffRoles != null) ? staffRolesMapper.entityToStaffRolesDTO(staffRoles) : null;
	}
	
	@Override
	public StaffRolesDTO insertStaffRoles(StaffRolesDTO staffRolesDTOinsert) throws IdmsBaseException{
	try {
			if (staffRolesDTOinsert != null) {
				StaffRoles staffRoles = staffRolesMapper.staffRolesDTOToEntity(staffRolesDTOinsert);
				StaffRoles insertedstaffRoles = staffRolesRepo.save(staffRoles);

				return (insertedstaffRoles != null) ? staffRolesMapper.entityToStaffRolesDTO(insertedstaffRoles) : null;
			}
		} catch (Exception e) {
			LOG.error("Error while inserting StaffRoles {} ", e);
		}
		return null;
	}
	
	@Override
	public List<StaffRolesDTO> retrieveAllStaffRoles() throws IdmsBaseException {
	try {
			List<StaffRoles> staffRolesList = staffRolesRepo.findAll();
			return (staffRolesList != null) ? staffRolesMapper.entityListToStaffRolesDTOList(staffRolesList) : null;
		} catch (Exception e) {
		LOG.error("Error message",e);		
		}
		return Collections.emptyList();
	}

	@Override
	public 	StaffRolesDTO updateStaffRoles(StaffRolesDTO staffRolesDTOUpdate) throws IdmsBaseException{
	try{
		if(staffRolesDTOUpdate !=null){
						StaffRoles staffRoles = staffRolesMapper.staffRolesDTOToEntity(staffRolesDTOUpdate);
				StaffRoles UpdatedstaffRoles = staffRolesRepo.saveAndFlush(staffRoles);
				return (UpdatedstaffRoles != null) ? staffRolesMapper.entityToStaffRolesDTO(UpdatedstaffRoles) : null;
					
		}
	}
	catch (Exception e){
			LOG.error("Error while updating StaffRoles {} ", e);
		}
	return null;
	}


	@Override
	public Boolean deleteById(Long staffRoleId) throws IdmsBaseException{
	try {
			StaffRoles staffRoles = staffRolesRepo.findOne(staffRoleId);
			if (staffRoles != null) {
				StaffMember loginUser = idmsBaseService.currentUser();
				FormatConverterUtils.setInitialDeleteValues(staffRoles, loginUser);
				staffRolesRepo.saveAndFlush(staffRoles);
				return true;
			}
		} catch (Exception e) {
			LOG.error("Error while deleting StaffRoles {} ", e);
		}
		return false;


	}
}

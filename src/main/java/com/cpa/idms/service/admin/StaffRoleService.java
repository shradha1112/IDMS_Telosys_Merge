package com.cpa.idms.service.admin;

import java.util.List;

import com.cpa.idms.backend.dao.exception.entities.IdmsBaseException;
import com.cpa.idms.service.admin.dto.StaffRolesDTO;

public interface StaffRoleService {

	StaffRolesDTO retrieveStaffRolesByStaffId(Long staffId);
	StaffRolesDTO insertStaffRoles(StaffRolesDTO staffRolesDTOinsert) throws IdmsBaseException;
	List<StaffRolesDTO> retrieveAllStaffRoles() throws IdmsBaseException;
	StaffRolesDTO updateStaffRoles(StaffRolesDTO staffRolesDTOUpdate) throws IdmsBaseException;
	Boolean deleteById(Long staffRoleId) throws IdmsBaseException;

}

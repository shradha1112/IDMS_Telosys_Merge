package com.cpa.idms.service.admin;

import java.sql.SQLException;
import java.util.List;

import com.cpa.idms.backend.dao.admin.entities.StaffMember;
import com.cpa.idms.service.admin.dto.DepartmentDTO;
import com.cpa.idms.service.admin.dto.DocumentCategoryDTO;
import com.cpa.idms.service.admin.dto.StaffMemberDTO;

public interface StaffMemberService {

	List<StaffMemberDTO> retrieveAllStaffMembers();

	StaffMemberDTO persistStaffMember(StaffMemberDTO staffMemberDTO);

	void updatePassword(String password, Long staffId);

	StaffMember findByEmail(String email);

	List<StaffMemberDTO> retrieveAllPrimaryProvider();

	StaffMemberDTO retrieveStaffMemberById(Long staffId);

	StaffMemberDTO updateStaffMemberById(StaffMemberDTO staffMemberDTOToUpdate);

	boolean checkStaffMemberInUse(Long staffId);

	boolean setUserLoginTime();

	boolean setUserLogoutTime(Long staffId);

	public Long removeStaffMemberById(Long staffId);

	StaffMemberDTO getLoginStatus();

}
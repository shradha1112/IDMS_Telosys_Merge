package com.cpa.idms.service.admin.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.idms.backend.dao.admin.DepartmentRepository;
import com.cpa.idms.backend.dao.admin.DocumentCategoryRepository;
import com.cpa.idms.backend.dao.admin.StaffMemberRepository;
import com.cpa.idms.backend.dao.admin.entities.Department;
import com.cpa.idms.backend.dao.admin.entities.DocumentCategory;
import com.cpa.idms.backend.dao.admin.entities.StaffMember;
import com.cpa.idms.service.admin.DepartmentService;
import com.cpa.idms.service.admin.DocumentCategoryService;
import com.cpa.idms.service.admin.IDMSBaseService;
import com.cpa.idms.service.admin.StaffMemberService;
import com.cpa.idms.service.admin.dto.DepartmentDTO;
import com.cpa.idms.service.admin.dto.DocumentCategoryDTO;
import com.cpa.idms.service.admin.dto.StaffMemberDTO;
import com.cpa.idms.service.admin.dto.mapper.DepartmentMapper;
import com.cpa.idms.service.admin.dto.mapper.DocumentCategoryMapper;
import com.cpa.idms.service.admin.dto.mapper.StaffMemberMapper;
import com.cpa.idms.util.FormatConverterUtils;


@Service
public class StaffMemberServiceImpl implements StaffMemberService {
	private static final Logger LOG = LoggerFactory.getLogger(StaffMemberServiceImpl.class);
	
	@Autowired
	private StaffMemberRepository staffMemberRepo;
	
	@Autowired
	private StaffMemberMapper staffMemberMapper;
	

	@Autowired
	private IDMSBaseService ehrBaseService;

	
	
	@Override
	public List<StaffMemberDTO> retrieveAllStaffMembers() {
		try {
			
			List<StaffMember> staffMemberList = staffMemberRepo.findAllStaffMembers();
		
			return (staffMemberList != null) ? staffMemberMapper.entityListToStaffMemberDTOList(staffMemberList) : null;
		}
		catch (Exception e){
			LOG.error("Error while retrieving all staff members ", e);
		}
		return Collections.emptyList();
	}
	
	


	@Override
	public StaffMemberDTO persistStaffMember(StaffMemberDTO staffMemberDTO) {
		try {
			if (staffMemberDTO != null) {
				StaffMember staffMemberToInsert = staffMemberMapper.staffMemberDTOToEntity(staffMemberDTO);
				StaffMember insertedStaffMember = staffMemberRepo.save(staffMemberToInsert);

				return (insertedStaffMember != null)
						? staffMemberMapper.entityToStaffMemberDTO(insertedStaffMember)
						: null;
			}
		} catch (Exception e) {
			LOG.error("Error while inserting staff Member {} ", e);
		}
		return null;
	}

	/**
	 * Retrieves list of all StaffMembers
	 * 
	 * @return List of all StaffMembers
	 */
/*	@Override
	public List<StaffMemberDTO> retrieveAllStaffMembers() {
		try {
			List<StaffMember> staffMemberList = staffMemberRepo.findAllActiveStaffMembers();
			return (staffMemberList != null) ? staffMemberMapper.entityListToStaffMemberDTOList(staffMemberList) : null;
		} catch (Exception e) {
			LOG.error("Error while retrieving all staff members {} ", e);
		}
		return Collections.emptyList();
	}*/

	public StaffMember findByEmail(String email) {
		return staffMemberRepo.findByEmail(email);
	}

	@Override
	public void updatePassword(String password, Long staffId) {
		StaffMember staff = staffMemberRepo.findOne(staffId);
		if (staff != null) {
			staff.setLoginKey(password);
			staffMemberRepo.saveAndFlush(staff);
		}
	}

	@Override
	public List<StaffMemberDTO> retrieveAllPrimaryProvider() {
		try {
			List<StaffMember> primaryProviderList = staffMemberRepo.findAllPrimaryProvider();
			return (primaryProviderList != null) ? staffMemberMapper.entityListToStaffMemberDTOList(primaryProviderList)
					: null;
		} catch (Exception e) {
			LOG.error("Error while retrieving all primary provider {} ", e);
		}
		return Collections.emptyList();
	}

	@Override
	public StaffMemberDTO retrieveStaffMemberById(Long staffId) {
		try {
			StaffMember staffMember = staffMemberRepo.findActiveOneByStaffMemberId(staffId);
			return (staffMember != null) ? staffMemberMapper.entityToStaffMemberDTO(staffMember) : null;
		} catch (Exception e) {
			LOG.error("Error while retrieving selected staff member {}", e);
		}
		return null;

	}

	@Override
	public StaffMemberDTO updateStaffMemberById(StaffMemberDTO staffMemberDTOToUpdate) {

		StaffMember staffMemberToUpdate = staffMemberRepo.findOne(staffMemberDTOToUpdate.getStaffId());
		// Check whether the correct organization & Clinic Location exists
		// before updating Staff Member Info

		if (staffMemberToUpdate != null) {
			staffMemberToUpdate.setActiveFlag(
					FormatConverterUtils.convertBooleantoActiveFlag(staffMemberDTOToUpdate.getActiveFlag()));


//		System.out.println("---------------------------- "+staffMemberDTOToUpdate.getActiveFlag());



		if (staffMemberToUpdate != null) {

			// Update every field except Organization, Clinic Location, Created By & Created
			// Date fields
			// !!! -- Staff Member once created for an Org should not be
			// reassigned to another Org -- !!!
			staffMemberToUpdate.setActiveFlag(
					FormatConverterUtils.convertBooleantoActiveFlag(staffMemberDTOToUpdate.getActiveFlag()));

			staffMemberToUpdate.setEmail(staffMemberDTOToUpdate.getEmail());
			staffMemberToUpdate.setFirstName(staffMemberDTOToUpdate.getFirstName());
			staffMemberToUpdate.setLastAction(staffMemberDTOToUpdate.getLastAction());
			staffMemberToUpdate.setLastActionDate(staffMemberDTOToUpdate.getLastActionDate());

			staffMemberToUpdate.setLastLoginDate(staffMemberDTOToUpdate.getLastLoginDate());
			staffMemberToUpdate.setLastName(staffMemberDTOToUpdate.getLastName());
			staffMemberToUpdate.setLoginId(staffMemberDTOToUpdate.getLoginId());
			staffMemberToUpdate.setLoginKey(staffMemberDTOToUpdate.getLoginKey());
			staffMemberToUpdate.setMiddleName(staffMemberDTOToUpdate.getMiddleName());
			staffMemberToUpdate.setMobileNo(staffMemberDTOToUpdate.getMobileNo());
			staffMemberToUpdate.setStaffId(staffMemberDTOToUpdate.getStaffId());
			staffMemberToUpdate.setStaffImage(staffMemberDTOToUpdate.getStaffImage());
			staffMemberToUpdate.setLastUpdatedBy(staffMemberDTOToUpdate.getLastUpdatedBy());
			staffMemberToUpdate.setLastUpdatedDate(staffMemberDTOToUpdate.getLastUpdatedDate());
			staffMemberToUpdate.setGender(staffMemberDTOToUpdate.getGender());

			staffMemberToUpdate.setStaffId(staffMemberDTOToUpdate.getStaffId());
			staffMemberToUpdate.setStaffImage(staffMemberDTOToUpdate.getStaffImage());
			staffMemberToUpdate.setLastUpdatedBy(staffMemberDTOToUpdate.getLastUpdatedBy());
			staffMemberToUpdate.setLastUpdatedDate(staffMemberDTOToUpdate.getLastUpdatedDate());

			staffMemberToUpdate.setGender(staffMemberDTOToUpdate.getGender());

			StaffMember updatedStaffMember = staffMemberRepo.save(staffMemberToUpdate);
			return (updatedStaffMember != null) ? staffMemberMapper.entityToStaffMemberDTO(updatedStaffMember) : null;
			}
		}
		return null;
	}

	@Override
	public boolean setUserLoginTime() {
		try {
			StaffMember staff = ehrBaseService.currentUser();
			StaffMember staffMemberToUpdate = staffMemberRepo.findOne(staff.getStaffId());

			if (staffMemberToUpdate != null) {
				staffMemberToUpdate.setLastLoginDate(new Date());
				staffMemberToUpdate.setLastAction("loggedIn");

				StaffMember updatedDetails = staffMemberRepo.save(staffMemberToUpdate);
				if (updatedDetails != null) {
					return true;
				}
				return true;
			}
			// return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean setUserLogoutTime(Long staffId) {
		try {
			StaffMember staffMemberToUpdate = staffMemberRepo.findOne(staffId);

			if (staffMemberToUpdate != null) {
				staffMemberToUpdate.setLastActionDate(new Date().toString());
				staffMemberToUpdate.setLastAction("loggedOut");

				StaffMember updatedDetails = staffMemberRepo.save(staffMemberToUpdate);
				if (updatedDetails != null) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	@Override
	public StaffMemberDTO getLoginStatus() {
		try {
			StaffMember loginUser = ehrBaseService.currentUser();
			System.out.println("login User"+loginUser);
			return (loginUser != null) ? staffMemberMapper.entityToStaffMemberDTO(loginUser) : null;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	
	@Override
	public boolean checkStaffMemberInUse(Long staffId) {
		try {
			//List<PatientDetails> patientList = patientDetailsRepo.getPatientsByStaffId(staffId);
			//if (patientList.isEmpty()) {
				return true;
		//	}
		} catch (Exception e) {
			LOG.error("Error while checking staff already in use or not {}", e);
		}
		return false;
	}

	@Override
	public Long removeStaffMemberById(Long staffId) {
		try {
			StaffMember loginUser = ehrBaseService.currentUser();
			StaffMember staffMemberToDelete = staffMemberRepo.findOne(staffId);
			if (staffMemberToDelete != null) {

				staffMemberToDelete.setLastUpdatedBy(loginUser.getLoginId());
				staffMemberToDelete.setLastUpdatedDate(new Date());
				staffMemberToDelete.setActiveFlag("N");
				staffMemberRepo.saveAndFlush(staffMemberToDelete);
			}
		} catch (Exception e) {
			LOG.error("Error while removing staff Member  {}", e);
		}
		return staffId;

	}
}
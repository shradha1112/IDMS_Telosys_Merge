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
import com.cpa.idms.backend.dao.admin.SubDepartmentRepository;
import com.cpa.idms.backend.dao.admin.entities.Department;
import com.cpa.idms.backend.dao.admin.entities.Project;
import com.cpa.idms.backend.dao.admin.entities.StaffMember;
import com.cpa.idms.backend.dao.admin.entities.SubDepartment;
import com.cpa.idms.backend.dao.exception.entities.IdmsBaseException;
import com.cpa.idms.service.admin.DepartmentService;
import com.cpa.idms.service.admin.IDMSBaseService;
import com.cpa.idms.service.admin.dto.DepartmentDTO;
import com.cpa.idms.service.admin.dto.ProjectDTO;
import com.cpa.idms.service.admin.dto.SubDepartmentDTO;
import com.cpa.idms.service.admin.dto.mapper.DepartmentMapper;
import com.cpa.idms.service.admin.dto.mapper.SubDepartmentMapper;
import com.cpa.idms.util.FormatConverterUtils;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	private static final Logger LOG = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	@Autowired
	private DepartmentRepository departmentRepo;

	@Autowired
	private SubDepartmentRepository subDeptRepo;

	@Autowired
	private DepartmentMapper departmentMapper;

	@Autowired
	private SubDepartmentMapper subDeptMapper;
	
	@Autowired
	private IDMSBaseService idmsBaseService;

	@Override
	public DepartmentDTO insertDeptData(DepartmentDTO dataToInsertDTO) throws IdmsBaseException {
		try {
			if (dataToInsertDTO != null) {
				Department deptToInsert = departmentMapper.departmentDTOToEntity(dataToInsertDTO);
				Department insertedDept = departmentRepo.save(deptToInsert);

				return (insertedDept != null) ? departmentMapper.entityToDepartmentDTO(insertedDept) : null;
			}
		} catch (Exception e) {

		}
		return null;
	}
	
	@Override
	public DepartmentDTO updateDeptData(DepartmentDTO dataToInsertDTO) throws IdmsBaseException {
		try {
			if (dataToInsertDTO != null) {
				Department deptToInsert = departmentMapper.departmentDTOToEntity(dataToInsertDTO);
				Department insertedDept = departmentRepo.saveAndFlush(deptToInsert);

				return (insertedDept != null) ? departmentMapper.entityToDepartmentDTO(insertedDept) : null;
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public DepartmentDTO getDepartmentDetailsById(Long deptId) throws IdmsBaseException {
		try {
			if(deptId != null) {
				Department departmentData = departmentRepo.findDepartmentById(deptId);
				return (departmentData != null) ? departmentMapper.entityToDepartmentDTO(departmentData) : null;
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Boolean deleteDepartment(Long deptId) throws IdmsBaseException {
		try {
			Department departmentObj = departmentRepo.findDepartmentById(deptId);
			if (departmentObj != null) {
				StaffMember loginUser = idmsBaseService.currentUser();
				FormatConverterUtils.setInitialDeleteValues(departmentObj, loginUser);
				System.out.println("@@@@@@@@@@@@@@@@@@@ "+departmentObj);
				departmentRepo.saveAndFlush(departmentObj);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<DepartmentDTO> retrieveAllDepartments() {
		try {
			List<Department> departmentList = departmentRepo.findAllDepartments();
			return (departmentList != null) ? departmentMapper.entityListTodepartmentDTOList(departmentList) : null;
		} catch (Exception e) {
			// LOG.error("Error while retrieving all clinic locations {} ", e);
		}
		return Collections.emptyList();
	}

	@Override
	public List<SubDepartmentDTO> retrieveAllSubDepartments() {
		try {
			List<SubDepartment> departmentList = subDeptRepo.findAllSubDepartments();
			return (departmentList != null) ? subDeptMapper.entityListTosubDepartmentDTOList(departmentList) : null;
		} catch (Exception e) {
			LOG.error("Error while retrieving all clinic locations {} ", e);
		}
		return Collections.emptyList();
	}
}
package com.cpa.idms.service.admin;

import java.sql.SQLException;
import java.util.List;

import com.cpa.idms.backend.dao.exception.entities.IdmsBaseException;
import com.cpa.idms.service.admin.dto.DepartmentDTO;
import com.cpa.idms.service.admin.dto.SubDepartmentDTO;

public interface DepartmentService {

	/* DEPARTMENT CRUD OPERATIONS */
	List<DepartmentDTO> retrieveAllDepartments()throws IdmsBaseException;
	
	DepartmentDTO getDepartmentDetailsById(Long deptId)throws IdmsBaseException;
	
	DepartmentDTO insertDeptData(DepartmentDTO dataToInsertDTO) throws IdmsBaseException;
	
	DepartmentDTO updateDeptData(DepartmentDTO dataToInsertDTO) throws IdmsBaseException;
	
	Boolean deleteDepartment(Long deptId) throws IdmsBaseException;

	
	/* SUB-DEPARTMENT CRUD OPERATIONS */
	List<SubDepartmentDTO> retrieveAllSubDepartments()throws IdmsBaseException;;

}

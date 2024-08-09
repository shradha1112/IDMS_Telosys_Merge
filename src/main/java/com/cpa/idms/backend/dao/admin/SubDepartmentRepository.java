package com.cpa.idms.backend.dao.admin;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpa.idms.backend.dao.admin.constants.DepartmentConstants;
import com.cpa.idms.backend.dao.admin.constants.SubDepartmentConstants;
import com.cpa.idms.backend.dao.admin.entities.Department;
import com.cpa.idms.backend.dao.admin.entities.SubDepartment;

@Repository
@Transactional
public interface SubDepartmentRepository extends JpaRepository<SubDepartment, Long> {

	@Query(value = SubDepartmentConstants.FIND_ALL_SUB_DEPARTMENTS, nativeQuery = true)
	List<SubDepartment> findAllSubDepartments();

	@Query(value = SubDepartmentConstants.FIND_ALL_SUB_DEPT_BY_DEPTID, nativeQuery = true)
	List<SubDepartment> findAllSubDepartmentsByDeptId(@Param("deptId")Long deptId);
}

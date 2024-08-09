package com.cpa.idms.backend.dao.admin;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpa.idms.backend.dao.admin.constants.DepartmentConstants;
import com.cpa.idms.backend.dao.admin.entities.Department;


@Repository
@Transactional
public interface DepartmentRepository extends JpaRepository<Department,Long> {
	
	@Query(value = DepartmentConstants.FIND_ALL_DEPARTMENTS, nativeQuery = true)
	List <Department> findAllDepartments();
	
	@Query(value = DepartmentConstants.FIND_ALL_DEPARTMENT_BY_ID, nativeQuery = true)
	Department findDepartmentById(@Param("deptId")Long deptId);
	
	
}

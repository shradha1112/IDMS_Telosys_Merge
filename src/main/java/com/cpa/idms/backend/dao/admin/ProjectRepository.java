package com.cpa.idms.backend.dao.admin;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpa.idms.backend.dao.admin.constants.ProjectConstants;
import com.cpa.idms.backend.dao.admin.entities.Department;
import com.cpa.idms.backend.dao.admin.entities.Project;


@Repository
@Transactional
public interface ProjectRepository extends JpaRepository<Project,Long> {
	
	@Query(value = ProjectConstants.FIND_ALL_PROJECTS, nativeQuery = true)
	List <Project> findAllProjects();
	
	@Query(value = ProjectConstants.FIND_ALL_PROJECTS_BY_DEPTID, nativeQuery = true)
	List <Project> findAllProjectsByDeptId(@Param("deptId")Long deptId);
}
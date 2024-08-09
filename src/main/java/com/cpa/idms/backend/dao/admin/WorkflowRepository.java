package com.cpa.idms.backend.dao.admin;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpa.idms.backend.dao.admin.constants.DepartmentConstants;
import com.cpa.idms.backend.dao.admin.constants.WorkflowConstants;
import com.cpa.idms.backend.dao.admin.entities.Department;
import com.cpa.idms.backend.dao.admin.entities.StaffMember;
import com.cpa.idms.backend.dao.admin.entities.Workflow;
import com.cpa.idms.backend.dao.admin.entities.WorkflowApprovalDetails;

@Repository
@Transactional
public interface WorkflowRepository extends JpaRepository<Workflow,Long>{
	

	@Query(value = WorkflowConstants.FIND_ALL_DOCUMENTS_BY_USER, nativeQuery = true)
	List <Workflow> findAllDocuments(@Param("firstName")String firstName);
	
	@Query(value = WorkflowConstants.FIND_ALL_DOCUMENT_APPROVAL_BY_USER, nativeQuery = true)
	List <Workflow> findAllPendingDoc(@Param("firstName")String firstName);

}

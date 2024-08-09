package com.cpa.idms.backend.dao.admin;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cpa.idms.backend.dao.admin.entities.StaffMember;
import com.cpa.idms.backend.dao.admin.entities.WorkflowApprovalDetails;

@Repository
@Transactional
public interface WorkflowDocumentDetailsRepository extends JpaRepository<WorkflowApprovalDetails,Long>{

}

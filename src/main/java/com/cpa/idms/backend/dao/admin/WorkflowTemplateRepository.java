/*
 * Created on 2021-05-06 ( Date ISO 2021-05-06 - Time 17:00:25 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.cpa.idms.backend.dao.admin;

import com.cpa.idms.backend.dao.admin.entities.WorkflowTemplate;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Jpa repository for WorkflowTemplate.
 * @author Rajol version 3.0.0
 */
@Repository
@Transactional
public interface WorkflowTemplateRepository  extends JpaRepository<WorkflowTemplate, Long> {}
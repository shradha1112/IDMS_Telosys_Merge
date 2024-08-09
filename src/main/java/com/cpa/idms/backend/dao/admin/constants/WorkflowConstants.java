package com.cpa.idms.backend.dao.admin.constants;

public class WorkflowConstants {

	public static final String FIND_ALL_DOCUMENTS_BY_USER = "SELECT * FROM workflow_details WHERE created_by= :firstName";
	public static final String FIND_ALL_DOCUMENT_APPROVAL_BY_USER = "SELECT * FROM workflow_details WHERE approver_id Like %:firstName%";

	
}		

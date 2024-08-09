package com.cpa.idms.service.admin;

import com.cpa.idms.backend.dao.admin.entities.StaffMember;

public interface S3Service {

	/*
	 * 1. Form the object path.
	 * 2. Check if object path exists.If present throw exception.
	 * 3. Create new object.
	 * 4. Setting the tag. Tag consist of projectId,createdBy,DocCategory,DocStatus.
	 */
	public String createNewDocument(StaffMember currentUser,Long projectId,String DocName);
	
	// fetch's the latest version of document
	public Object fetchLatestDocument(String objectId);
	
	// Returns S3 object if the path exists else return NULL.
	public Object fetchDocumentByPath(String objectPath);
	
	/*
	 * 1. Form the object path.
	 * 2. If path does not exists throw exception.
	 * 3. create new version of document.
	 * 4. Setting the tag. Tag consist of projectId,createdBy,DocCategory,DocStatus.
	 */
	public String createVersionDocument(StaffMember currentUser,Long projectId,String DocName);
	
	public Boolean deletObjectById(String objectId);
	
	public Boolean deletObjectByPath(String objectPath);
}

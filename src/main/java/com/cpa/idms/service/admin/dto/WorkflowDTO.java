package com.cpa.idms.service.admin.dto;

import java.util.Date;

public class WorkflowDTO {

	private Long workflowId;
	private String projectId;
	private String deptId;
	private String categoryId;
	private String approverId;
	private String docName;
	private String url;
	private String remarks;
	private Boolean activeFlag;
	private String dueDate;
	private String createdBy;
	private Date createdOn;

	public Long getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(Long workflowId) {
		this.workflowId = workflowId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getApproverId() {
		return approverId;
	}

	public void setApproverId(String approverId) {
		this.approverId = approverId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "WorkflowDTO [workflowId=" + workflowId + ", projectId=" + projectId + ", deptId=" + deptId
				+ ", categoryId=" + categoryId + ", approverId=" + approverId + ", docName=" + docName + ", url=" + url
				+ ", remarks=" + remarks + ", activeFlag=" + activeFlag + ", dueDate=" + dueDate + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + "]";
	}

}

package com.cpa.idms.backend.dao.admin.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "workflow_details")
public class Workflow {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "workflow_id_seq", allocationSize = 1)
	@Column(name = "workflow_id")
	private Long workflowId;

	@NotBlank
	@Column(name = "project_id", nullable = false)
	private String projectId;

	@NotBlank
	@Column(name = "dept_id", nullable = false)
	private String deptId;

	@NotBlank
	@Column(name = "category_id", nullable = false)
	private String categoryId;

	@NotBlank
	@Column(name = "approver_id", nullable = false)
	private String approverId;

	@Size(max = 500)
	@Column(name = "documentName", length = 500)
	private String docName;

	@Column(name = "document_url")
	private String url;

	@NotBlank
	@Size(max = 500)
	@Column(name = "remarks", length = 500, nullable = false)
	private String remarks;

	@Column(name = "active_flag")
	private String activeFlag;

	@NotBlank
	@Size(max = 500)
	@Column(name = "created_by", length = 500, nullable = false)
	private String createdBy;

	@Column(name = "created_on")
	private Date createdOn;

	@Column(name = "due_date")
	private String dueDate;

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

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
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

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
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
		return "Workflow [workflowId=" + workflowId + ", projectId=" + projectId + ", deptId=" + deptId
				+ ", categoryId=" + categoryId + ", approverId=" + approverId + ", docName=" + docName + ", url=" + url
				+ ", remarks=" + remarks + ", activeFlag=" + activeFlag + ", createdBy=" + createdBy + ", createdOn="
				+ createdOn + ", dueDate=" + dueDate + "]";
	}
}

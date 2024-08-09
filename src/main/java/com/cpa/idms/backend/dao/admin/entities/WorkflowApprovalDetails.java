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
@Table(name = "workflow_approval_details")
public class WorkflowApprovalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "workflow_approv_id_seq", allocationSize = 1)
	@Column(name = "approval_id")
	private Long approvalId;

	@Column(name = "workflow_id")
	private Long workFlowId;

	@Column(name = "staff_id")
	private Long staffId;

	@Size(max = 500)
	@Column(name = "document_status", length = 500)
	private String documentStatus;

	@Size(max = 500)
	@Column(name = "comments", length = 500)
	private String comments;

	@Size(max = 500)
	@Column(name = "documentName", length = 500)
	private String docName;

	@Column(name = "document_url")
	private String url;

	@Column(name = "active_flag", length = 1)
	private String activeFlag;

	@Size(max = 500)
	@Column(name = "created_by", length = 500)
	private String createdBy;

	@Column(name = "created_on")
	private Date createdOn;

	@Size(max = 500)
	@Column(name = "modified_by", length = 500)
	private String modifiedBy;

	@Column(name = "modified_on")
	private Date modififedOn;

	public Long getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(Long approvalId) {
		this.approvalId = approvalId;
	}

	public Long getWorkFlowId() {
		return workFlowId;
	}

	public void setWorkFlowId(Long workFlowId) {
		this.workFlowId = workFlowId;
	}

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModififedOn() {
		return modififedOn;
	}

	public void setModififedOn(Date modififedOn) {
		this.modififedOn = modififedOn;
	}

	public String getDocumentStatus() {
		return documentStatus;
	}

	public void setDocumentStatus(String documentStatus) {
		this.documentStatus = documentStatus;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	@Override
	public String toString() {
		return "WorkflowApprovalDetails [approvalId=" + approvalId + ", workFlowId=" + workFlowId + ", staffId="
				+ staffId + ", documentStatus=" + documentStatus + ", comments=" + comments + ", docName=" + docName
				+ ", url=" + url + ", activeFlag=" + activeFlag + ", createdBy=" + createdBy + ", createdOn="
				+ createdOn + ", modifiedBy=" + modifiedBy + ", modififedOn=" + modififedOn + "]";
	}
}

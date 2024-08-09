package com.cpa.idms.backend.dao.admin.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "documents_version_workflow")
public class DocumentsVersionWorkflow {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 2L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "documents_version_workflow_id_seq", allocationSize=1)
	@Column(name="documents_version_workflow_id")
    private Long docVersionWorkflowId; 
	
	
	@ManyToOne
	@JoinColumn(name="project_documents_version_id")
    private ProjectDocumentsVersion projectDocumentsVersion;
	
	                                                    
	@OneToOne                                                   
	@JoinColumn(name="project_documents_id")    
	private ProjectDocuments projectDocuments;                          

	
	@ManyToOne
	@JoinColumn(name="staff_id")
    private StaffMember staffMembers;  
	
	
	@OneToOne
	@JoinColumn(name="staff_role_id")
    private StaffRoles staffRoles;
	
	@NotBlank
	@Size(max = 5000)
	@Column(name="doc_version_review_comments", length = 5000, nullable = false)
    private String docVersionReviewComments;
	
	@NotBlank
	@Column(name="approval_status")
    private String approvalStatus;
	
	@NotBlank
	@Column(name="estimate_day")
    private Long estimateDay;
	
	@Column(name="expiry_date")
    private Date expiryDate;
	
	@Column(name="approver_order",length = 10)
    private Long approverOrder; 
	

	@Size(max = 500)
	@Column(name="created_by", length = 500, nullable = false)
    private String createdBy;
	
	@Column(name="created_date")
	private Date createdDate;
	

	@Size(max = 500)
	@Column(name="modified_by")
    private String modifiedBy;
	
	@Column(name="modified_date")
	private Date modifiedDate;
	
	@Size(max = 500)
	@Column(name="filed_1")
    private String field1;
	
	@Size(max = 500)
	@Column(name="field_2")
    private String field2;
	
	@Size(max = 500)
	@Column(name="field_3")
    private String field3;
	
	@Size(max = 500)
	@Column(name="field_4")
    private String field4;

	public Long getApproverOrder() {
		return approverOrder;
	}

	public void setApproverOrder(Long approverOrder) {
		this.approverOrder = approverOrder;
	}

	public Long getDocVersionWorkflowId() {
		return docVersionWorkflowId;
	}

	public void setDocVersionWorkflowId(Long docVersionWorkflowId) {
		this.docVersionWorkflowId = docVersionWorkflowId;
	}


	public ProjectDocumentsVersion getProjectDocumentsVersion() {
		return projectDocumentsVersion;
	}

	public void setProjectDocumentsVersion(ProjectDocumentsVersion projectDocumentsVersion) {
		this.projectDocumentsVersion = projectDocumentsVersion;
	}

	public StaffRoles getStaffRoles() {
		return staffRoles;
	}

	public void setStaffRoles(StaffRoles staffRoles) {
		this.staffRoles = staffRoles;
	}

	public ProjectDocuments getProjectDocuments() {
		return projectDocuments;
	}

	public void setProjectDocuments(ProjectDocuments projectDocuments) {
		this.projectDocuments = projectDocuments;
	}

	public StaffMember getStaffMembers() {
		return staffMembers;
	}

	public void setStaffMembers(StaffMember staffMembers) {
		this.staffMembers = staffMembers;
	}

	public String getDocVersionReviewComments() {
		return docVersionReviewComments;
	}

	public void setDocVersionReviewComments(String docVersionReviewComments) {
		this.docVersionReviewComments = docVersionReviewComments;
	}



	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public Long getEstimateDay() {
		return estimateDay;
	}

	public void setEstimateDay(Long estimateDay) {
		this.estimateDay = estimateDay;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

	public String getField4() {
		return field4;
	}

	public void setField4(String field4) {
		this.field4 = field4;
	}
	
	
	
}

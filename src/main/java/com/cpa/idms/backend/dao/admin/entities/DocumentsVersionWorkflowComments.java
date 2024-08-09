package com.cpa.idms.backend.dao.admin.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "documents_version_workflow_comments")
public class DocumentsVersionWorkflowComments {
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 2L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "documents_version_workflow_comments_id_seq", allocationSize=1)
	@Column(name="documents_version_workflow_comments_id")
    private Long docVersionWorkflowCommentId; 
	
	@OneToOne
	@JoinColumn(name="documents_version_workflow_id")
    private DocumentsVersionWorkflow docVersionWorkflow; 
	
	@ManyToOne
	@JoinColumn(name="project_documents_version_id")
    private ProjectDocumentsVersion projectDocumentsVersion;
	                                                   
	@ManyToOne                                                  
	@JoinColumn(name="project_documents_id")    
	private ProjectDocuments projectDocuments; 
	
	
	@ManyToOne
	@JoinColumn(name="staff_id")
    private StaffMember staffMenbers; 
	
	@Size(max = 5000)
	@Column(name="comments",length = 5000)
	private String comments;
	
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

	public Long getDocVersionWorkflowCommentId() {
		return docVersionWorkflowCommentId;
	}

	public void setDocVersionWorkflowCommentId(Long docVersionWorkflowCommentId) {
		this.docVersionWorkflowCommentId = docVersionWorkflowCommentId;
	}

	public DocumentsVersionWorkflow getDocVersionWorkflow() {
		return docVersionWorkflow;
	}

	public void setDocVersionWorkflow(DocumentsVersionWorkflow docVersionWorkflow) {
		this.docVersionWorkflow = docVersionWorkflow;
	}

	public ProjectDocumentsVersion getProjectDocumentsVersion() {
		return projectDocumentsVersion;
	}

	public void setProjectDocumentsVersion(ProjectDocumentsVersion projectDocumentsVersion) {
		this.projectDocumentsVersion = projectDocumentsVersion;
	}

	public ProjectDocuments getProjectDocuments() {
		return projectDocuments;
	}

	public void setProjectDocuments(ProjectDocuments projectDocuments) {
		this.projectDocuments = projectDocuments;
	}

	public StaffMember getStaffMenbers() {
		return staffMenbers;
	}

	public void setStaffMenbers(StaffMember staffMenbers) {
		this.staffMenbers = staffMenbers;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

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
@Table(name="workflow_template")
public class WorkflowTemplate {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 2L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "workflow_template_id_seq", allocationSize=1)
	@Column(name="workflow_template_id")
    private Long workflowTemplateId; 
	
	@NotBlank
	@Size(max = 500)
	@Column(name="template_name",length = 500, nullable = false)
    private String templateName; 
	
	@NotBlank
	@Size(max = 5000)
	@Column(name="template_desc", length = 5000, nullable = false)
    private String templateDescription;
	
	@Column(name="visibility")
    private String visibility; 
	
	
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

	public Long getWorkflowTemplateId() {
		return workflowTemplateId;
	}

	public void setWorkflowTemplateId(Long workflowTemplateId) {
		this.workflowTemplateId = workflowTemplateId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplateDescription() {
		return templateDescription;
	}

	public void setTemplateDescription(String templateDescription) {
		this.templateDescription = templateDescription;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
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

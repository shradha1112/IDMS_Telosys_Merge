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
@Table(name="docuemnt_category")
public class DocumentCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "document_category_id_seq", allocationSize=1)
	@Column(name="category_id")
    private Long categoryId; 
	
	@NotBlank
	@Column(name="dept_id", nullable = false)
	private Long deptId;
	
	@NotBlank
	@Size(max = 500)
	@Column(name="category_name", length = 500, nullable = false)
    private String categoryName;
	
	@NotBlank
	@Size(max = 500)
	@Column(name="category_desc", length = 500, nullable = false)
    private String categoryDesc;
	
	
	@NotBlank
	@Size(max = 500)
	@Column(name="visibility", length = 500, nullable = false)
    private String visibility;
	
	@Column(name="active_flag", length = 1, nullable = false)
	private String activeFlag;
	
	@NotBlank
	@Size(max = 500)
	@Column(name="created_by", length = 500, nullable = false)
    private String createdBy;
	
	@Column(name="created_on")
	private Date createdOn;
	
	@NotBlank
	@Size(max = 500)
	@Column(name="modified_by", length = 500, nullable = false)
    private String modifiedBy;
	
	@Column(name="modified_on")
	private Date modififedOn;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
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

	@Override
	public String toString() {
		return "DocuemntCategory [categoryId=" + categoryId + ", deptId=" + deptId + ", categoryName=" + categoryName
				+ ", categoryDesc=" + categoryDesc + ", visibility=" + visibility + ", activeFlag=" + activeFlag
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", modifiedBy=" + modifiedBy
				+ ", modififedOn=" + modififedOn + "]";
	}
}

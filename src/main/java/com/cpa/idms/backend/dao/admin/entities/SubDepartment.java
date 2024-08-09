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
@Table(name="sub_department")
public class SubDepartment {

private static final long serialVersionUID = 2L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "sub_department_id_seq", allocationSize=1)
	@Column(name="sub_dept_id")
    private Long subDeptId; 
	
	@NotBlank
	@Size(max = 500)
	@Column(name="sub_dept_name", length = 500, nullable = false)
    private String subDeptName;
	
	@NotBlank
	@Size(max = 500)
	@Column(name="sub_dept_desc", length = 500, nullable = false)
    private String subDeptDesc;
	
	@NotBlank
	@Size(max = 500)
	@Column(name="sub_dept_head", length = 500, nullable = false)
    private String subDeptHead;
	
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
	
	@NotBlank
	@Size(max = 500)
	@Column(name="department_id", length = 500, nullable = false)
    private String departmentId; 

	public Long getSubDeptId() {
		return subDeptId;
	}

	public void setSubDeptId(Long subDeptId) {
		this.subDeptId = subDeptId;
	}

	public String getSubDeptName() {
		return subDeptName;
	}

	public void setSubDeptName(String subDeptName) {
		this.subDeptName = subDeptName;
	}

	public String getSubDeptDesc() {
		return subDeptDesc;
	}

	public void setSubDeptDesc(String subDeptDesc) {
		this.subDeptDesc = subDeptDesc;
	}

	public String getSubDeptHead() {
		return subDeptHead;
	}

	public void setSubDeptHead(String subDeptHead) {
		this.subDeptHead = subDeptHead;
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

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public Date getModififedOn() {
		return modififedOn;
	}

	public void setModififedOn(Date modififedOn) {
		this.modififedOn = modififedOn;
	}

	@Override
	public String toString() {
		return "SubDepartment [subDeptId=" + subDeptId + ", subDeptName=" + subDeptName + ", subDeptDesc=" + subDeptDesc
				+ ", subDeptHead=" + subDeptHead + ", activeFlag=" + activeFlag + ", createdBy=" + createdBy
				+ ", createdOn=" + createdOn + ", modifiedBy=" + modifiedBy + ", modififedOn=" + modififedOn + "]";
	}	
	
}

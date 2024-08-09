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
@Table(name="department")
public class Department {

	private static final long serialVersionUID = 2L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "department_id_seq", allocationSize=1)
	@Column(name="dept_id")
    private Long deptId; 
	
	
	@NotBlank
	@Size(max = 500)
	@Column(name="dept_name", length = 500, nullable = false)
    private String deptName; 
	
	@Size(max = 500)
	@Column(name="dept_desc", length = 500)
    private String deptDesc;
	
	@NotBlank
	@Size(max = 500)
	@Column(name="dept_head", length = 500, nullable = false)
    private String deptHead;
	
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

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptDesc() {
		return deptDesc;
	}

	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}

	public String getDeptHead() {
		return deptHead;
	}

	public void setDeptHead(String deptHead) {
		this.deptHead = deptHead;
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
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", deptDesc=" + deptDesc + ", deptHead="
				+ deptHead + ", activeFlag=" + activeFlag + ", createdBy=" + createdBy + ", createdOn=" + createdOn
				+ ", modififedOn=" + modififedOn + ", modififedOn=" + modififedOn + "]";
	}
}

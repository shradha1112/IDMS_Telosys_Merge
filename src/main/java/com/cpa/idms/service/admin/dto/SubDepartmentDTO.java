package com.cpa.idms.service.admin.dto;

import java.util.Date;

public class SubDepartmentDTO {

	private Long subDeptId;
	private String subDeptName;
	private String subDeptDesc;
	private String subDeptHead;
	private Boolean activeFlag;
	private String createdBy;
	private Date createdOn;
	private String modifiedBy;
	private Date modififedOn;
	private Long departmentId;

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

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
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

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "SubDepartmentDTO [subDeptId=" + subDeptId + ", subDeptName=" + subDeptName + ", subDeptDesc="
				+ subDeptDesc + ", subDeptHead=" + subDeptHead + ", activeFlag=" + activeFlag + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", modifiedBy=" + modifiedBy + ", modififedOn=" + modififedOn
				+ "]";
	}

}

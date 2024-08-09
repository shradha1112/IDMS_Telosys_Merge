package com.cpa.idms.service.admin.dto;

import java.util.Date;

public class DepartmentDTO {

	private Long deptId;
	private String deptName;
	private String deptDesc;
	private String deptHead;
	private Boolean activeFlag;
	private String createdBy;
	private Date createdOn;
	private String modifiedBy;
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
	@Override
	public String toString() {
		return "DepartmentDTO [deptId=" + deptId + ", deptName=" + deptName + ", deptDesc=" + deptDesc + ", deptHead="
				+ deptHead + ", activeFlag=" + activeFlag + ", createdBy=" + createdBy + ", createdOn=" + createdOn
				+ ", modifiedBy=" + modifiedBy + ", modififedOn=" + modififedOn + "]";
	}
}

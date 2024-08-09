package com.cpa.idms.service.admin.dto;

import java.util.Date;

public class ProjectDTO {

	private Long projectId;
	private String projectName;
	private String desc;
	private Long managerId;
	private Boolean activeFlag;
	private String createdBy;
	private Date createdOn;
	private String modifiedBy;
	private Date modififedOn;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
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
		return "ProjectDTO [projectId=" + projectId + ", projectName=" + projectName + ", desc=" + desc + ", managerId="
				+ managerId + ", activeFlag=" + activeFlag + ", createdBy=" + createdBy + ", createdOn=" + createdOn
				+ ", modifiedBy=" + modifiedBy + ", modififedOn=" + modififedOn + "]";
	}

}

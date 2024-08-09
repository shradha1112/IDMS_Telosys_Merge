package com.cpa.idms.service.admin.dto;

import java.util.Date;

public class DocumentCategoryDTO {

	private Long categoryId;
	private Long deptId;
	private String categoryName;
	private String categoryDesc;
	private String visibility;
	private Boolean activeFlag;
	private String createdBy;
	private Date createdOn;
	private String modifiedBy;
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
		return "DocumentCategoryDTO [categoryId=" + categoryId + ", deptId=" + deptId + ", categoryName=" + categoryName
				+ ", categoryDesc=" + categoryDesc + ", visibility=" + visibility + ", activeFlag=" + activeFlag
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", modifiedBy=" + modifiedBy
				+ ", modififedOn=" + modififedOn + "]";
	}
}

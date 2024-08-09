package com.cpa.idms.service.admin.dto;

import java.util.Date;
import javax.validation.constraints.Size;

/**
 * DTO representing Staff Member Entity. 
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
public class StaffMemberDTO {
	
    private Long staffId; 
	
    private String loginId; 
	
    private String loginKey; 
	
    private String firstName; 
    
	private String departmentId;
	
    private String middleName; 
	
    private String lastName; 
    
    private String staffImage; 
			
    private Boolean activeFlag;
	
	private String mobileNo;
		
	private String email;	
	
	private String providerType;	
	
    private String designation; 
    
    private Long organizationId;

	private String lastAction;
	
	private Date lastLoginDate;

	private String lastActionDate;

	private Date createdDate;
	
	@Size(max = 100)
	private String createdBy;
	
	private Date lastUpdatedDate;
	
	@Size(max = 100)
	private String lastUpdatedBy;
	
	private Date doj;
	
	private String gender;

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginKey() {
		return loginKey;
	}

	public void setLoginKey(String loginKey) {
		this.loginKey = loginKey;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStaffImage() {
		return staffImage;
	}

	public void setStaffImage(String staffImage) {
		this.staffImage = staffImage;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProviderType() {
		return providerType;
	}

	public void setProviderType(String providerType) {
		this.providerType = providerType;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getLastAction() {
		return lastAction;
	}

	public void setLastAction(String lastAction) {
		this.lastAction = lastAction;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLastActionDate() {
		return lastActionDate;
	}

	public void setLastActionDate(String lastActionDate) {
		this.lastActionDate = lastActionDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	@Override
	public String toString() {
		return "StaffMemberDTO [staffId=" + staffId + ", loginId=" + loginId + ", loginKey=" + loginKey + ", firstName="
				+ firstName + ", departmentId=" + departmentId + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", staffImage=" + staffImage + ", activeFlag=" + activeFlag + ", mobileNo=" + mobileNo + ", email="
				+ email + ", providerType=" + providerType + ", designation=" + designation + ", organizationId="
				+ organizationId + ", lastAction=" + lastAction + ", lastLoginDate=" + lastLoginDate
				+ ", lastActionDate=" + lastActionDate + ", createdDate=" + createdDate + ", createdBy=" + createdBy
				+ ", lastUpdatedDate=" + lastUpdatedDate + ", lastUpdatedBy=" + lastUpdatedBy + ", doj=" + doj
				+ ", gender=" + gender + "]";
	}
}
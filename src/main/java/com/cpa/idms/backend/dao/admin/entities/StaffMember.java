package com.cpa.idms.backend.dao.admin.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;


/**
 * Entity Class representing Staff Member Table. This table stores information
 * about the Staff Members.
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
@Entity
@Table(name = "staff")
public class StaffMember implements Serializable {
	private static final long serialVersionUID = 2L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "staff_member_id_seq", allocationSize = 1)
	@Column(name = "staff_id")
	private Long staffId;

	@NotBlank
	@Size(max = 10)
	@Column(name = "login_id", length = 10, nullable = false)
	private String loginId;

	@NotBlank
	@Size(max = 500)
	@Column(name = "login_key", length = 500, nullable = false)
	private String loginKey;

	@Size(max = 500)
	@Column(name = "department_id", length = 500)
	private String departmentId;

	@ManyToOne
	@JoinColumn(name = "organization_id", nullable = false)
	private Organization organization;

	@NotBlank
	@Size(max = 500)
	@Column(name = "manager", length = 500, nullable = false)
	private String manager;

	@NotBlank
	@Size(max = 500)
	@Column(name = "first_name", length = 500, nullable = false)
	private String firstName;

	@Size(max = 500)
	@Column(name = "middle_name", length = 500)
	private String middleName;

	@NotBlank
	@Size(max = 500)
	@Column(name = "last_name", length = 500, nullable = false)
	private String lastName;

	@Column(name = "staff_image")
	private String staffImage;

	@Size(max = 100)
	@Column(name = "designation", length = 100)
	private String designation;

	@Column(name = "active_flag", length = 1, nullable = false)
	private String activeFlag;

	@NotBlank
	@Size(max = 500)
	@Column(name = "mobile_no", length = 500)
	private String mobileNo;

	@NotBlank
	@Size(max = 500)
	@Column(name = "email", length = 500)
	private String email;

	@Size(max = 500)
	@Column(name = "last_action", length = 500)
	private String lastAction;

	@Column(name = "last_login_dt")
	private Date lastLoginDate;

	@Column(name = "last_action_dt")
	private String lastActionDate;

	@Column(name = "created_date", nullable = false)
	private Date createdDate;

	@Size(max = 100)
	@Column(name = "created_by", length = 100)
	private String createdBy;

	@Column(name = "last_updated_date", nullable = false)
	private Date lastUpdatedDate;

	@Size(max = 100)
	@Column(name = "last_updated_by", length = 100)
	private String lastUpdatedBy;

	@Column(name = "doj")
	private Date doj;

	@Column(name = "gender")
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

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
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
	
	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	@Override
	public String toString() {
		return "StaffMember [staffId=" + staffId + ", loginId=" + loginId + ", loginKey=" + loginKey + ", departmentId="
				+ departmentId +", manager=" + manager + ", firstName="
				+ firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", staffImage=" + staffImage
				+ ", designation=" + designation + ", activeFlag=" + activeFlag + ", mobileNo=" + mobileNo + ", email="
				+ email + ", lastAction=" + lastAction + ", lastLoginDate=" + lastLoginDate + ", lastActionDate="
				+ lastActionDate + ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", lastUpdatedDate="
				+ lastUpdatedDate + ", lastUpdatedBy=" + lastUpdatedBy + ", doj=" + doj + ", gender=" + gender + "]";
	}

}

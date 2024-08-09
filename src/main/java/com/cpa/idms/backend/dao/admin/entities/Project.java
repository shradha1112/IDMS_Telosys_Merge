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
@Table(name="project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "project_id_seq", allocationSize=1)
	@Column(name="project_id")
    private Long projectId; 
	
	@NotBlank
	@Size(max = 500)
	@Column(name="project_name", length = 500, nullable = false)
    private String projectName;
	
	@NotBlank
	@Size(max = 500)
	@Column(name="project_desc", length = 500, nullable = false)
    private String desc;
	
	@NotBlank
	@Column(name="manager_id", length = 1, nullable = false)
	private Long managerId;
	
	
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

	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
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
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	
	
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", desc=" + desc + ", managerId="
				+ managerId + ", activeFlag=" + activeFlag + ", createdBy=" + createdBy + ", createdOn=" + createdOn
				+ ", modifiedBy=" + modifiedBy + ", modififedOn=" + modififedOn + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
}

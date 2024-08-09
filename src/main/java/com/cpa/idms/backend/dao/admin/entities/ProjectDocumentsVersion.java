package com.cpa.idms.backend.dao.admin.entities;

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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="project_documents_version")
public class ProjectDocumentsVersion {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 2L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "project_documents_version_id_seq", allocationSize=1)
	@Column(name="project_documents_version_id")
	private Long projectDocVersionId; 


	@ManyToOne
	@JoinColumn(name="project_documents_id")
	private ProjectDocuments projectDocuments;

	@NotBlank
	@Column(name="version_no", length = 500, nullable = false)
	private Long versionNo; 

	@Column(name="active_flag", length = 1, nullable = false)
	private Boolean activeFlag;


	@NotBlank
	@Size(max = 500)
	@Column(name="raw_file_path", length = 500, nullable = false)
	private String rawfilePath;

	@NotBlank
	@Size(max = 500)
	@Column(name="raw_object_id")
	private String rawObjectId; 	


	@Size(max = 500)
	@Column(name="doc_status", length = 500, nullable = false)
	private String documentStatus;


	@NotBlank
	@Size(max = 500)
	@Column(name="doc_visibility", length = 500, nullable = false)
	private String documentVisibility;

	@NotBlank
	@Size(max = 500)
	@Column(name="pdf_path", length = 500, nullable = false)
	private String pdfPath;

	@NotBlank
	@Size(max = 500)
	@Column(name="pdf_convert_status", length = 500, nullable = false)
	private String pdfConvertStatus;


	@Column(name="pdf_convert_date")
	private Date pdfConvertDate;

	@NotBlank                      
	@Size(max = 500)               
	@Column(name="pdf_object_id")  
	private String pdfObjectId; 	

	@NotBlank
	@Size(max = 500)
	@Column(name="web_path", length = 500, nullable = false)
	private String webPath;

	@NotBlank
	@Size(max = 500)
	@Column(name="web_cov_status", length = 500, nullable = false)
	private String webCovStatus;


	@Column(name="web_conv_date")
	private Date webConvertDate;


	@NotBlank                       
	@Size(max = 500)                
	@Column(name="web_object_id")   
	private String webObjectId; 	

	@NotBlank
	@Column(name="estimate_day")
	private Long estimateDay;

	@Column(name="expiry_date")
	private Date expiryDate;

	@Size(max = 500)
	@Column(name="created_by", length = 500, nullable = false)
	private String createdBy;

	@Column(name="created_date")
	private Date createdDate;


	@Size(max = 500)
	@Column(name="modified_by")
	private String modifiedBy;

	@Column(name="modified_date")
	private Date modifiedDate;

	@Size(max = 500)
	@Column(name="filed_1")
	private String field1;

	@Size(max = 500)
	@Column(name="field_2")
	private String field2;

	@Size(max = 500)
	@Column(name="field_3")
	private String field3;

	@Size(max = 500)
	@Column(name="field_4")
	private String field4;




	public String getRawObjectId() {
		return rawObjectId;
	}

	public void setRawObjectId(String rawObjectId) {
		this.rawObjectId = rawObjectId;
	}

	public String getPdfObjectId() {
		return pdfObjectId;
	}

	public void setPdfObjectId(String pdfObjectId) {
		this.pdfObjectId = pdfObjectId;
	}

	public String getWebObjectId() {
		return webObjectId;
	}

	public void setWebObjectId(String webObjectId) {
		this.webObjectId = webObjectId;
	}

	public Long getProjectDocVersionId() {
		return projectDocVersionId;
	}

	public void setProjectDocVersionId(Long projectDocVersionId) {
		this.projectDocVersionId = projectDocVersionId;
	}

	public ProjectDocuments getProjectDocuments() {
		return projectDocuments;
	}

	public void setProjectDocuments(ProjectDocuments projectDocuments) {
		this.projectDocuments = projectDocuments;
	}

	public Long getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(Long versionNo) {
		this.versionNo = versionNo;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getRawfilePath() {
		return rawfilePath;
	}

	public void setRawfilePath(String rawfilePath) {
		this.rawfilePath = rawfilePath;
	}

	public String getDocumentStatus() {
		return documentStatus;
	}

	public void setDocumentStatus(String documentStatus) {
		this.documentStatus = documentStatus;
	}

	public String getDocumentVisibility() {
		return documentVisibility;
	}

	public void setDocumentVisibility(String documentVisibility) {
		this.documentVisibility = documentVisibility;
	}

	public String getPdfPath() {
		return pdfPath;
	}

	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}

	public String getPdfConvertStatus() {
		return pdfConvertStatus;
	}

	public void setPdfConvertStatus(String pdfConvertStatus) {
		this.pdfConvertStatus = pdfConvertStatus;
	}

	public Date getPdfConvertDate() {
		return pdfConvertDate;
	}

	public void setPdfConvertDate(Date pdfConvertDate) {
		this.pdfConvertDate = pdfConvertDate;
	}

	public String getWebPath() {
		return webPath;
	}

	public void setWebPath(String webPath) {
		this.webPath = webPath;
	}

	public String getWebCovStatus() {
		return webCovStatus;
	}

	public void setWebCovStatus(String webCovStatus) {
		this.webCovStatus = webCovStatus;
	}

	public Date getWebConvertDate() {
		return webConvertDate;
	}

	public void setWebConvertDate(Date webConvertDate) {
		this.webConvertDate = webConvertDate;
	}

	public Long getEstimateDay() {
		return estimateDay;
	}

	public void setEstimateDay(Long estimateDay) {
		this.estimateDay = estimateDay;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

	public String getField4() {
		return field4;
	}

	public void setField4(String field4) {
		this.field4 = field4;
	}
}

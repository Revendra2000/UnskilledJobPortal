package com.persistent.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Job")
public class Job {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "JOB_ID_SEQ")	
	private int jobId;
	
	@Column(name = "aadhar_no" , length=12)
	private String aadharNo;
	
	@Column(name = "category_id" , length=10)
	private int categoryId;
	
	@Column(name = "work_state" , length=30)
	private String  workState;
	
	@Column(name = "work_city" , length=30)
	private String workCity;
	
	@Column(name = "work_pincode" , length=30)
	private String workPincode;
	
	@Column(name = "work_area" , length=50)
	private String workArea;
	
	@Column(name = "work_description" , length=100)
	private String workDescription;
	
	@Column(name = "is_active" , length=1)
	private boolean isActive;
	
	@Column(name = "estimated_cost" , length=7)
	private int estimatedCost;
	
	@Column(name = "date_of_post" )
	private Date dateOfPost;
	
	@Column(name = "last_date")
	private Date lastDate;
	
	@Column(name = "job_type" , length=30)
	private String jobType;
	
	@Column(name = "job_assigned_to" , length=12)
	private String jobAssignedTo;

	public Job() {
		super();
	}

	public Job(int jobId, String aadharNo, int categoryId, String workState, String workCity, String workPincode,
			String workArea, String workDescription, boolean isActive, int estimatedCost, Date dateOfPost,
			Date lastDate, String jobType, String jobAssignedTo) {
		super();
		this.jobId = jobId;
		this.aadharNo = aadharNo;
		this.categoryId = categoryId;
		this.workState = workState;
		this.workCity = workCity;
		this.workPincode = workPincode;
		this.workArea = workArea;
		this.workDescription = workDescription;
		this.isActive = isActive;
		this.estimatedCost = estimatedCost;
		this.dateOfPost = dateOfPost;
		this.lastDate = lastDate;
		this.jobType = jobType;
		this.jobAssignedTo = jobAssignedTo;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getWorkState() {
		return workState;
	}

	public void setWorkState(String workState) {
		this.workState = workState;
	}

	public String getWorkCity() {
		return workCity;
	}

	public void setWorkCity(String workCity) {
		this.workCity = workCity;
	}

	public String getWorkPincode() {
		return workPincode;
	}

	public void setWorkPincode(String workPincode) {
		this.workPincode = workPincode;
	}

	public String getWorkArea() {
		return workArea;
	}

	public void setWorkArea(String workArea) {
		this.workArea = workArea;
	}

	public String getWorkDescription() {
		return workDescription;
	}

	public void setWorkDescription(String workDescription) {
		this.workDescription = workDescription;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getEstimatedCost() {
		return estimatedCost;
	}

	public void setEstimatedCost(int estimatedCost) {
		this.estimatedCost = estimatedCost;
	}

	public Date getDateOfPost() {
		return dateOfPost;
	}

	public void setDateOfPost(Date dateOfPost) {
		this.dateOfPost = dateOfPost;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getJobAssignedTo() {
		return jobAssignedTo;
	}

	public void setJobAssignedTo(String jobAssignedTo) {
		this.jobAssignedTo = jobAssignedTo;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", aadharNo=" + aadharNo + ", categoryId=" + categoryId + ", workState="
				+ workState + ", workCity=" + workCity + ", workPincode=" + workPincode + ", workArea=" + workArea
				+ ", workDescription=" + workDescription + ", isActive=" + isActive + ", estimatedCost=" + estimatedCost
				+ ", dateOfPost=" + dateOfPost + ", lastDate=" + lastDate + ", jobType=" + jobType + ", jobAssignedTo="
				+ jobAssignedTo + "]";
	}
	
	
	
	
}

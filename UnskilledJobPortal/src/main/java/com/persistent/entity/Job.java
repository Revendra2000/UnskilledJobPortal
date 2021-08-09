package com.persistent.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Job {

	@Id
	private int jobId;
	private String aadhar_no;
	private int category_id;
	private String  work_state;
	private String work_city;
	private String work_pincode;
	private String work_area;
	private String work_description;
	private boolean is_active;
	private int estimated_cost;
	private Date date_of_post;
	private Date last_date;
	private String job_type;
	private String job_assigned_to;
	
	public Job() {
		super();
	}

	public Job(int jobId, String aadhar_no, int category_id, String work_state, String work_city, String work_pincode,
			String work_area, String work_description, boolean is_Active, int estimated_cost, Date date_of_post,
			Date last_date, String job_type, String job_assigned_to) {
		super();
		this.jobId = jobId;
		this.aadhar_no = aadhar_no;
		this.category_id = category_id;
		this.work_state = work_state;
		this.work_city = work_city;
		this.work_pincode = work_pincode;
		this.work_area = work_area;
		this.work_description = work_description;
		this.is_active = is_Active;
		this.estimated_cost = estimated_cost;
		this.date_of_post = date_of_post;
		this.last_date = last_date;
		this.job_type = job_type;
		this.job_assigned_to = job_assigned_to;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getAadhar_no() {
		return aadhar_no;
	}

	public void setAadhar_no(String aadhar_no) {
		this.aadhar_no = aadhar_no;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getWork_state() {
		return work_state;
	}

	public void setWork_state(String work_state) {
		this.work_state = work_state;
	}

	public String getWork_city() {
		return work_city;
	}

	public void setWork_city(String work_city) {
		this.work_city = work_city;
	}

	public String getWork_pincode() {
		return work_pincode;
	}

	public void setWork_pincode(String work_pincode) {
		this.work_pincode = work_pincode;
	}

	public String getWork_area() {
		return work_area;
	}

	public void setWork_area(String work_area) {
		this.work_area = work_area;
	}

	public String getWork_description() {
		return work_description;
	}

	public void setWork_description(String work_description) {
		this.work_description = work_description;
	}

	public boolean is_active() {
		return is_active;
	}

	public void set_active(boolean isActive) {
		this.is_active = isActive;
	}

	public int getEstimated_cost() {
		return estimated_cost;
	}

	public void setEstimated_cost(int estimated_cost) {
		this.estimated_cost = estimated_cost;
	}

	public Date getDate_of_post() {
		return date_of_post;
	}

	public void setDate_of_post(Date date_of_post) {
		this.date_of_post = date_of_post;
	}

	public Date getLast_date() {
		return last_date;
	}

	public void setLast_date(Date last_date) {
		this.last_date = last_date;
	}

	public String getJob_type() {
		return job_type;
	}

	public void setJob_type(String job_type) {
		this.job_type = job_type;
	}

	public String getJob_assigned_to() {
		return job_assigned_to;
	}

	public void setJob_assigned_to(String job_assigned_to) {
		this.job_assigned_to = job_assigned_to;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", aadhar_no=" + aadhar_no + ", category_id=" + category_id + ", work_state="
				+ work_state + ", work_city=" + work_city + ", work_pincode=" + work_pincode + ", work_area="
				+ work_area + ", work_description=" + work_description + ", isActive=" + is_active + ", estimated_cost="
				+ estimated_cost + ", date_of_job_post=" + date_of_post + ", last_date=" + last_date + ", job_type="
				+ job_type + ", job_assigned_to=" + job_assigned_to + "]";
	}

	
	
}

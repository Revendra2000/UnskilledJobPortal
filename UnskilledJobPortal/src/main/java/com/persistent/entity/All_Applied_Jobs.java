package com.persistent.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

class JobID implements Serializable
{
	private int job_id;
	private String aadhar_worker;
	public JobID() {
		super();
	}
	
	public JobID(int job_id, String aadhar_worker) {
		super();
		this.job_id = job_id;
		this.aadhar_worker = aadhar_worker;
	}
	
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public String getAadhar_worker() {
		return aadhar_worker;
	}
	public void setAadhar_worker(String aadhar_worker) {
		this.aadhar_worker = aadhar_worker;
	}
	
}


@Entity
@IdClass(JobID.class)
public class All_Applied_Jobs {

	@Id
	private int job_id;
	
	@Id
	private String aadhar_worker;
	
	public All_Applied_Jobs() {
		super();
	}
	
	public All_Applied_Jobs(int job_id, String aadhar_worker) {
		super();
		this.job_id = job_id;
		this.aadhar_worker = aadhar_worker;
	}
	
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public String getAadhar_worker() {
		return aadhar_worker;
	}
	public void setAadhar_worker(String aadhar_worker) {
		this.aadhar_worker = aadhar_worker;
	}
	
	@Override
	public String toString() {
		return "All_Applied_Jobs [job_id=" + job_id + ", aadhar_worker=" + aadhar_worker + "]";
	}
	
	
	
}

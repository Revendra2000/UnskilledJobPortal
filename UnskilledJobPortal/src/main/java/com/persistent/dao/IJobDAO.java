package com.persistent.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.persistent.entity.JobDetails;

public interface IJobDAO extends CrudRepository<JobDetails, Integer> {
	
//	@Modifying
//	@Transactional
//	@Query(value = "insert into job_details (aadhar_no,category_id,date_of_post,estimated_cost,job_type,last_date,work_area,work_city,work_description,work_pincode,work_state) values (?,?,?,?,?,?,?,?,?,?,?) ", nativeQuery = true)
//		int insertJobDetails(String aadharNo,int categoryId,Date dateOfPost,int estimatedCost,String jobType,Date lastDate,String workArea,String workCity,String workDescription,String workPincode,String workState);
	
	
	
	@Modifying
	@Transactional
	@Query(value = "insert into job_details (aadhar_no,category_id,date_of_post,estimated_cost,job_type,last_date,work_area,work_city,work_description,work_pincode,work_state) values (?1 ,?2 ,?3 ,?4 ,?5 ,?6 ,?7 ,?8 ,?9 ,?10 ,?11 ) ", nativeQuery = true)
		int insertJobDetails(String aadharNo,int categoryId,Date dateOfPost,int estimatedCost,String jobType,Date lastDate,String workArea,String workCity,String workDescription,String workPincode,String workState);
	
	
	@Query(value="SELECT * FROM Job_Details WHERE Aadhar_No = ?1 ORDER BY JOB_ID DESC", nativeQuery = true)
	  List<JobDetails> findAllById(String aadharNo);
}

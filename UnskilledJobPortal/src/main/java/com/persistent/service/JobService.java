package com.persistent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.dao.IJobDAO;

@Service("jobService")
public class JobService {

	@Autowired
	private IJobDAO dao;
	
}

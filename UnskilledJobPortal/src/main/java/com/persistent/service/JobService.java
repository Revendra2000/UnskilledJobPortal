package com.persistent.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.persistent.dao.IJobDAO;

public class JobService {

	@Autowired
	private IJobDAO dao;
	
}

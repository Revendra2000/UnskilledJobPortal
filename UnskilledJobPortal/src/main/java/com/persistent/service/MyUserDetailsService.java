package com.persistent.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
//
//import com.persistent.dao.IUserDao;
import com.persistent.entity.MyUserDetails;
//import com.persistent.entity.Users;


@Service
public class MyUserDetailsService //implements UserDetailsService{
	{

//	@Autowired
//	private IUserDao userDao;
//	
//	@Override
//	public UserDetails loadUserByUsername(String aadhar_no) throws UsernameNotFoundException {
//		Optional<Users> user = userDao.findById(aadhar_no);
//		System.out.println(user +"==========="+aadhar_no);
//		
//		user.orElseThrow(() -> new UsernameNotFoundException("Not Found: "+ aadhar_no));
//		
//		return user.map(MyUserDetails::new).get();
//	}

}

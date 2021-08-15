package com.persistent.entity;


import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.persistent.entity.AppliedUserDetails;

@SpringBootTest

public class AppliedUserDetailsEntityTest {

	@Test
	public void UserJobIdTest() {
		AppliedUserDetails aud=new AppliedUserDetails();
		String id="201";
		
		aud.setJobId(id);
		String result=aud.getJobId();
		
		assertEquals(id, result);
		
	}
	
	@Test
	public void UserAadharTest() {
		AppliedUserDetails aud=new AppliedUserDetails();
		String aadhar="0000 1111 2222 3333";
		
		aud.setAadharNo(aadhar);
		String result=aud.getAadharNo();
		
		assertEquals(aadhar, result);
		
	}
	
	@Test
	public void UserFullNameTest() {
		AppliedUserDetails aud=new AppliedUserDetails();
		String fullname="This is full Name";
		
		aud.setFullName(fullname);
		String result=aud.getFullName();
		
		assertEquals(fullname, result);
	}
	
	@Test
	public void UserGenderTest() {
		AppliedUserDetails aud=new AppliedUserDetails();
		String gender="Male";
		
		aud.setGender(gender);
		String result=aud.getGender();
		
		assertEquals(gender, result);
	}
	
	@Test
	public void UserMobileNoTest() {
		AppliedUserDetails aud=new AppliedUserDetails();
		String mobno="9876543210";
		
		aud.setMobileNo(mobno);
		String result=aud.getMobileNo();
		
		assertEquals(mobno, result);
	}
	
	@Test
	public void UserAddressTest() {
		AppliedUserDetails aud=new AppliedUserDetails();
		String addr="ABC Road";
		
		aud.setAddress(addr);
		String result=aud.getAddress();
		
		assertEquals(addr, result);
	}
	
	@Test
	public void TestUserToStringEmptyObject() {
		AppliedUserDetails aud=new AppliedUserDetails();
		assertEquals(aud.toString(),"AppliedUserDetails [jobId=null, aadharNo=null, fullName=null, gender=null, mobileNo=null, address=null]");
		
	}
	
	@Test
	public void TestUserToStringWithObject() {
		AppliedUserDetails aud=new AppliedUserDetails();
		aud.setAadharNo("0000 1111 2222 3333");
		aud.setAddress("ABC Road");
		aud.setFullName("This is full Name");
		aud.setGender("Male");
		aud.setJobId("201");
		aud.setMobileNo("9876543210");
		
		String result="AppliedUserDetails [jobId="+"201"+", aadharNo="+"0000 1111 2222 3333"+", fullName="+"This is full Name"+", gender="+"Male"+", mobileNo="+"9876543210"+", address="+"ABC Road]";                                              
		
		assertEquals(aud.toString(),result);
	}
}

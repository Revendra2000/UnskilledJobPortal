package com.persistent.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	
	@Id
	private String aadhar_no;
	private String first_name;
	private String last_name;
	private String gender;
	private String password;
	private String mobile_no;
	private String user_type;
	private String address;
	private String skills;
	private String roles = "ROLE_USER";
	
	public Users() {
		super();
	}


	public String getRoles() {
		return roles;
	}
//
//
//	public void setRoles(String roles) {
//		this.roles = roles;
//	}


	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getAadhar_no() {
		return aadhar_no;
	}

	public void setAadhar_no(String aadhar_no) {
		this.aadhar_no = aadhar_no;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", aadhar_no=" + aadhar_no + ", first_name=" + first_name + ", last_name="
				+ last_name + ", gender=" + gender + ", password=" + password + ", mobile_no=" + mobile_no
				+ ", user_type=" + user_type + ", address=" + address + ", skills=" + skills + ", roles=" + roles + "]";
	}
	
}
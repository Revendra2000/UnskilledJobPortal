package com.persistent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "Users")
public class User {
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "USER_ID_SEQ")
    private int userId;
	
	@Id
	@Column(name = "aadhar_no" , length=12)
	private String aadhar;	
	
	@Column(name="first_name" , length=30)
	private String firstName;
	
	@Column(name="last_name" , length=30)
	private String lastName;
	
	@Column(name="gender" , length=1)
	private String gender;
	
	@Column(name="password" , length=30)
	private String password;
	
	@Column(name="contact" , length=10)
	private String contact;
	
	@Column(name="address" , length=50)
	private String address;
	
	@Column(name="role" , length=10)
	private String role;

	public User() {
		super();
	}

	public User(int userId, int id, String aadhar, String firstName, String lastName, String gender, String password,
			String contact, String address, String role) {
		super();
		this.userId = userId;
		this.aadhar = aadhar;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.password = password;
		this.contact = contact;
		this.address = address;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", aadhar=" + aadhar + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", password=" + password + ", contact=" + contact
				+ ", address=" + address + ", role=" + role + "]";
	}
	
	
	
	
	
}

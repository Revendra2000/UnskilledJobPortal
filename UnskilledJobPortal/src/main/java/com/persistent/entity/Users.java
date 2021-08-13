package com.persistent.entity;
	
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Users")
public class Users {
	
	@Column(name = "USER_ID" , columnDefinition = "NUMBER", nullable = false)
    private int userId;
	
	@Id
	@Column(name = "AADHAR_NO" , columnDefinition = "VARCHAR2 (12)")
	private String aadhar;	
	
	@Column(name="FIRST_NAME" , columnDefinition = "VARCHAR2 (30)")
	private String firstName;
	
	@Column(name="LAST_NAME" , columnDefinition = "VARCHAR2 (30)")
	private String lastName;
	
	@Column(name="GENDER" , columnDefinition = "VARCHAR2 (1) CHECK (GENDER IN ('F','M'))")
	private String gender;
	
	@Column(name="PASSWORD" , columnDefinition = "VARCHAR2 (50)" , nullable = false)
	private String password;
	
	@Column(name="CONTACT" , columnDefinition = "VARCHAR2 (10)" , nullable = false)
	private String contact;
	
	@Column(name="ADDRESS" , columnDefinition = "VARCHAR2 (50)")
	private String address;
	
	@Column(name="ROLES" , columnDefinition = "VARCHAR2(15)  DEFAULT 'ROLE_USER'")
	private String roles;

	public Users() {
		super();
	}

	public Users(int userId, int id, String aadhar, String firstName, String lastName, String gender, String password,
			String contact, String address, String roles) {
		super();
		this.userId = userId;
		this.aadhar = aadhar;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.password = password;
		this.contact = contact;
		this.address = address;
		this.roles = roles;
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

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", aadhar=" + aadhar + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", password=" + password + ", contact=" + contact
				+ ", address=" + address + ", roles=" + roles + "]";
	}
	
	
}

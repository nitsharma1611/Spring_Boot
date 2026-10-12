package com.sharma.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sharma.common.BaseDTO;

@Entity
@Table(name = "st_student")
public class StudentDTO extends BaseDTO {
	@Column(name = "firstName", length = 50)
	private String firstName;
	
	@Column(name = "lastName", length = 50)
	private String lastName;
	
	@Column(name = "dob")
	private Date dob;
	
	@Column(name = "mobile", length = 50)
	private String mobileNo;
	
	@Column(name = "email", length = 50)
	private String email;

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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

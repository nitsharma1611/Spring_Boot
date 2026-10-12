package com.sharma.form;

import java.util.Date;

import com.sharma.common.BaseDTO;
import com.sharma.common.BaseForm;
import com.sharma.dto.StudentDTO;
import com.sharma.dto.UserDTO;



public class StudentForm extends BaseForm {
	private String firstName;
	
	private String lastName;
	
	private Date dob;
	
	private String mobileNo;
	
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

	@Override
	public BaseDTO getDto() {
	StudentDTO dto = (StudentDTO) initDTO(new StudentDTO());
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setDob(dob);
		dto.setMobileNo(mobileNo);
		dto.setEmail(email);
		return dto;
	}

}

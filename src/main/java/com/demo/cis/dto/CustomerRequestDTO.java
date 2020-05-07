package com.demo.cis.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.demo.cis.validator.DateOfBirth;

public class CustomerRequestDTO {

	@NotEmpty(message = "First Name {null.empty}")
	@Pattern(regexp = "^[a-zA-Z'-]{1,30}", message = "First Name {invalid}")
	private String firstName;
	
	@NotEmpty(message = "Last Name {null.empty}")
	@Pattern(regexp = "^[a-zA-Z'-]{1,30}", message = "Last Name {invalid}")
	private String lastName;
	
	@Pattern(regexp = "^[a-zA-Z'-]{1,30}", message = "Middle Name {invalid}")
	private String middleName;
	
	@NotEmpty(message = "Primary Phone {null.empty}")
	@Pattern(regexp = "[0-9]{10}", message = "Primary Phone {invalid}")
	private String primaryPhone;
	
	@Pattern(regexp = "[0-9]{10}", message = "Secondary Phone {invalid}")
	private String secPhone;
	
	@NotEmpty(message = "Gender {null.empty}")
	@Pattern(regexp = "[MF]", message = "Gender {invalid}")
	private String gender;
	
	@NotNull(message = "Date of Birth {null.empty}")
	@DateOfBirth(message = "Date of Birth {invalid}")
	private LocalDate dob;
	
	@NotEmpty(message = "Email {null.empty}")
	@Email(message = "Email {invalid}")
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
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getPrimaryPhone() {
		return primaryPhone;
	}
	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}
	public String getSecPhone() {
		return secPhone;
	}
	public void setSecPhone(String secPhone) {
		this.secPhone = secPhone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "CustomerCreationDTO [firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName
				+ ", primaryPhone=" + primaryPhone + ", secPhone=" + secPhone + ", gender=" + gender + ", dob=" + dob
				+ "]";
	}
	
	
}

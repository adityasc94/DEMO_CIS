package com.fnb.cis.dto;

import java.time.LocalDate;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CustomerRequestDTO {

	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	private String middleName;
	
	@NotBlank
	@Digits(integer = 10, fraction = 0)
	private String primaryPhone;
	
	private String secPhone;
	
	@NotBlank
	private String gender;
	
	@NotNull
	private LocalDate dob;
	
	@NotBlank
	@Email
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

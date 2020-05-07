package com.demo.cis.dto;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorDTO {
	
	private List<FieldErrorDTO> fieldErrors = new ArrayList<>();
	
	public void addFieldError(String field, String message) {
		FieldErrorDTO fieldError = new FieldErrorDTO(field, message);
		fieldErrors.add(fieldError);
	}

	public List<FieldErrorDTO> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldErrorDTO> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
	
	
}

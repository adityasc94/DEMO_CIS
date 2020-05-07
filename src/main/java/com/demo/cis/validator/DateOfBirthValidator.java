package com.demo.cis.validator;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateOfBirthValidator implements ConstraintValidator<DateOfBirth, LocalDate> {

	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
		
		return value.isAfter(LocalDate.of(1900, 01, 01));
	}


}

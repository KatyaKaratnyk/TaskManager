package ua.karatnyk.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import ua.karatnyk.validation.annotation.MaxSizeString;

@Component
public class MaxSizeStringValidator implements ConstraintValidator<MaxSizeString, String>{

	@Override
	public void initialize(MaxSizeString maxSizeString) {
		
		
	}

	@Override
	public boolean isValid(String text, ConstraintValidatorContext arg1) {
		if(text.length() <= 50)
			return true;
		return false;
	}

}

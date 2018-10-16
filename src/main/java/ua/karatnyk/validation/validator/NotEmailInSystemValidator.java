package ua.karatnyk.validation.validator;

import java.util.NoSuchElementException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.karatnyk.service.UserService;
import ua.karatnyk.validation.annotation.NotEmailInSystem;

@Component
public class NotEmailInSystemValidator implements ConstraintValidator<NotEmailInSystem, String>{
	
	@Autowired
	private UserService userService;
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext arg1) {
		try {
			userService.findUserByLogin(email);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}

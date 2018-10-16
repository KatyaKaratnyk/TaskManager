package ua.karatnyk.validation.validator;

import java.util.NoSuchElementException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.karatnyk.service.UserService;
import ua.karatnyk.validation.annotation.Unique;

@Component
public class UniqueValidator implements ConstraintValidator<Unique, String>{
	
	@Autowired
	private UserService userService;

	@Override
	public void initialize(Unique arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext arg1) {
		try {
			userService.findUserByLogin(email);
			return false;
		} catch (NoSuchElementException e) {
			return true;
		}
	}

}

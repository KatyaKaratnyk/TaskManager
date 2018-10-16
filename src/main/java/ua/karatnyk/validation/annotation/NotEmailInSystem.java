package ua.karatnyk.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import ua.karatnyk.validation.validator.NotEmailInSystemValidator;

@Target(value = {ElementType.FIELD, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotEmailInSystemValidator.class)
public @interface NotEmailInSystem {
	
	String message() default "нема користувача з вказаною поштою";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};

}

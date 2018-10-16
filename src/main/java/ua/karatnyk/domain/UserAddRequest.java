package ua.karatnyk.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.karatnyk.validation.annotation.MaxSizeString;
import ua.karatnyk.validation.annotation.NotEmail;
import ua.karatnyk.validation.annotation.NotEmpty;
import ua.karatnyk.validation.annotation.NotNullString;
import ua.karatnyk.validation.annotation.Unique;

@Getter
@Setter
@NoArgsConstructor
public class UserAddRequest {
	
	@NotNullString
	@NotEmpty
	@MaxSizeString
	private String firstName;
	
	@NotNullString
	@NotEmpty
	@MaxSizeString
	private String lastName;
	
	@NotNullString
	@NotEmpty
	@Unique
	@NotEmail
	@MaxSizeString
	private String email;
	
	@NotNullString
	@NotEmpty
	@MaxSizeString
	private String password;

}

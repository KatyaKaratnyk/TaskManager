package ua.karatnyk.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.karatnyk.validation.annotation.MaxSizeString;
import ua.karatnyk.validation.annotation.NotEmail;
import ua.karatnyk.validation.annotation.NotEmailInSystem;
import ua.karatnyk.validation.annotation.NotNullString;

@Getter
@Setter
@NoArgsConstructor
public class EmailShareRequest {
	
	private int id;
	
	@NotNullString
	@NotEmail
	@NotEmailInSystem
	@MaxSizeString
	private String email;

}

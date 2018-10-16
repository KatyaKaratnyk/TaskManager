package ua.karatnyk.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.karatnyk.validation.annotation.MaxSizeString;
import ua.karatnyk.validation.annotation.NotEmpty;
import ua.karatnyk.validation.annotation.NotNullString;

@Getter
@Setter
@NoArgsConstructor
public class TaskAddRequest {
	
	@NotNullString
	@MaxSizeString
	@NotEmpty
	private String name;
	
	private String description;
	
	@NotNullString
	@NotEmpty
	@MaxSizeString
	private String dateExecute;

}

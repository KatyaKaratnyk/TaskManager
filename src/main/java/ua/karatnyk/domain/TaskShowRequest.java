package ua.karatnyk.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaskShowRequest {
	
	private int id;
	
	private String autor;
	
	private String name;
	
	private String description;
	
	private String date;

}

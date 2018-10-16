package ua.karatnyk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ua.karatnyk.entity.UserEntity;
import ua.karatnyk.enums.Role;
import ua.karatnyk.service.UserService;

@Controller
public class AddObjectsController {
	
	/*@Autowired
	private UserService userService;
	
	@GetMapping("/add_users") 
	public String addUsers() {
		UserEntity user1 = new UserEntity();
		user1.setEmail("m@i.ua");
		user1.setFirstName("Max");
		user1.setLastName("Smith");
		user1.setRole(Role.ROLE_USER);
		user1.setPassword("1111");
		userService.saveUser(user1);
		
		UserEntity user2 = new UserEntity();
		user2.setEmail("l@i.ua");
		user2.setFirstName("Paul");
		user2.setLastName("Rex");
		user2.setRole(Role.ROLE_USER);
		user2.setPassword("1111");
		userService.saveUser(user2);
		
		return "home";
		
	}*/
	
	

}

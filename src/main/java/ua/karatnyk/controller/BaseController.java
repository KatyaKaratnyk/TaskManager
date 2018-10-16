package ua.karatnyk.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ua.karatnyk.domain.UserAddRequest;
import ua.karatnyk.entity.UserEntity;
import ua.karatnyk.mapper.UserMapper;
import ua.karatnyk.service.UserService;


@Controller
public class BaseController {

	@Autowired
	private UserService userService;
	
	@GetMapping({"/", "/login"})
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/register") 
	public String addUserShowPage(Model model) {
		model.addAttribute("userAddRequestModel", new UserAddRequest());
		
		return "register";
	}
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute("userAddRequestModel") @Valid UserAddRequest request, 
			BindingResult result, Principal principal) {
		if(result.hasErrors()) {
			return "register";
		}
		try {
			UserEntity entity = UserMapper.userAddRequestToUserEntity(request);
			userService.saveUser(entity);
		} catch (NullPointerException e) {
			e.printStackTrace();
			return "home";
		}
		return "register_success";
	}
	
}

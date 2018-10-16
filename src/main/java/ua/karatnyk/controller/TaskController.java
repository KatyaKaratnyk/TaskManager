package ua.karatnyk.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import ua.karatnyk.domain.EmailShareRequest;
import ua.karatnyk.domain.TaskAddRequest;
import ua.karatnyk.domain.TaskEditRequest;
import ua.karatnyk.domain.TaskShowRequest;
import ua.karatnyk.entity.TaskEntity;
import ua.karatnyk.entity.UserEntity;
import ua.karatnyk.mapper.TaskMapper;
import ua.karatnyk.service.TaskService;
import ua.karatnyk.service.UserService;

@Controller
@SessionAttributes({"taskModel", "emailShareModel"})
public class TaskController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/user")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/tasks")
	public String showPageTasks(Principal principal, Model model) {
		List<TaskEntity> tasks = taskService.notDeleted(userService.findUserByLogin(principal.getName()));
		model.addAttribute("tasksModel", TaskMapper.listEntitiesToListRequests(tasks));
		return "show_tasks";
	}
	
	
	@GetMapping("/add_task") 
	public String showAddTaskPage(Model model) {
		model.addAttribute("taskAddRequestModel", new TaskAddRequest());
		return "add_task";
	}
	
	@PostMapping("/add_task")
	public String addTaskPage(@ModelAttribute("taskAddRequestModel") @Valid TaskAddRequest request, 
			BindingResult result, Principal principal) {
		if(result.hasErrors()) {
			return "add_task";
		}
		try {
			TaskEntity entity = TaskMapper.requestToEntity(request, userService.findUserByLogin(principal.getName()));
			taskService.save(entity);
		} catch (NullPointerException e) {
			e.printStackTrace();
			return "home";
		}
		return "redirect:/tasks";
	}
	
	@GetMapping("task{taskNumber}")
	public String showTaskPage(@PathVariable("taskNumber") int taskNumber, Principal principal, Model model) {
		TaskEntity taskEntity = taskService.findById(taskNumber, userService.findUserByLogin(principal.getName()));
		if(taskEntity == null) {
			return "home";
		}
		TaskShowRequest request = TaskMapper.entityToShowRequest(taskEntity);
		model.addAttribute("taskShowModel", request);
		return "task_page";
	}
	
	@GetMapping("task{taskNumber}/edit")
	public String editTaskShowPage(@PathVariable("taskNumber") int taskNumber, Principal principal, Model model) {
		
		try {
			TaskEntity taskEntity = taskService.findById(taskNumber, userService.findUserByLogin(principal.getName()));
			TaskEditRequest request = TaskMapper.entityToAddRequest(taskEntity);
			model.addAttribute("taskModel", request);
			return "edit_task";
			
		} catch (NullPointerException e) {
			return "home";
		}
	}
	
	@PostMapping("task{taskNumber}/edit")
	public String editTask(@PathVariable("taskNumber") int taskNumber,
			@ModelAttribute("taskModel") @Valid TaskEditRequest request, BindingResult result) {
		
		if(result.hasErrors()) {
			return "edit_task";
		}
		if(request.getId() != taskNumber) {
			return "redirect:/task" + request.getId();
		}
		try {
			taskService.update(request.getName(), request.getDescription(), TaskMapper.convertStringToDate(request.getDateExecute()),
					taskNumber);
			return "redirect:/task{taskNumber}";

			
		} catch (Exception e) {
			e.printStackTrace();
			return "home";
		}
		
	}
	
	@GetMapping("task{taskNumber}/delete") 
	public String deleteTask(@PathVariable("taskNumber") int taskNumber, Principal principal) {
		TaskEntity task = taskService.findById(taskNumber, userService.findUserByLogin(principal.getName()));
		if(task == null) {
			return "redirect:/tasks";
		}
		else {
			taskService.update(task.getId());
			return "redirect:/tasks";
		}
	}
	
	@GetMapping("task{taskNumber}/share")
	public String shareTaskShowPage(@PathVariable("taskNumber") int taskNumber, Model model) {
		EmailShareRequest request = new EmailShareRequest();
		request.setId(taskNumber);
		model.addAttribute("emailShareModel", request);
		return "share_task";
	}
	
	@PostMapping("task{taskNumber}/share")
	public String shareTask(@PathVariable("taskNumber") int taskNumber,
			@ModelAttribute("emailShareModel") @Valid EmailShareRequest request, BindingResult result) {
		if(result.hasErrors()) {
			return "share_task";
		}
		if(taskNumber != request.getId()) {
			return "redirect:/task" + request.getId();
		}
		UserEntity entity = userService.findUserByLogin(request.getEmail());
		TaskEntity taskEntity = taskService.findById(request.getId());
		if(taskService.findById(taskNumber, entity) != null) {
			return "redirect:/task{taskNumber}";
		}
		taskEntity.getUsers().add(entity);
		taskService.save(taskEntity);
		return "redirect:/task{taskNumber}";
	}
	
}

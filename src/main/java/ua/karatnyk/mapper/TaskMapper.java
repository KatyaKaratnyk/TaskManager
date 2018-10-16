package ua.karatnyk.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ua.karatnyk.domain.TaskAddRequest;
import ua.karatnyk.domain.TaskEditRequest;
import ua.karatnyk.domain.TaskShowRequest;
import ua.karatnyk.entity.TaskEntity;
import ua.karatnyk.entity.UserEntity;

public interface TaskMapper {
	
	public static TaskShowRequest entityToShowRequest(TaskEntity task) {
		TaskShowRequest request = new TaskShowRequest();
		request.setAutor(task.getCreateBy().getFirstName() + " " + task.getCreateBy().getLastName());
		request.setName(task.getName());
		request.setDescription(task.getDescription());
		request.setDate(convertDateToString(task.getExecutionTime()));
		request.setId(task.getId());
		return request;
	}
	
	public static List<TaskShowRequest> listEntitiesToListRequests(List<TaskEntity> taskEntities) {
		if(taskEntities.isEmpty()) {
			return null;
		}
		List<TaskShowRequest> requests = new ArrayList<>();
		for(TaskEntity e: taskEntities) {
			requests.add(entityToShowRequest(e));
		}
		return requests;
	}
	
	public static TaskEntity requestToEntity(TaskAddRequest request, UserEntity user) {
		TaskEntity entity = new TaskEntity();
		entity.setCreateBy(user);
		entity.setDescription(request.getDescription());
		entity.setExecutionTime(convertStringToDate(request.getDateExecute()));
		entity.setName(request.getName());
		entity.getUsers().add(user);
		return entity;
	}
	
	public static Date convertStringToDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date newDate;
		try {
			newDate = sdf.parse(date);
			return newDate;
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static String convertDateToString(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String result = format.format(date);
		return result;
	}
	
	public static TaskEditRequest entityToAddRequest(TaskEntity task) {
		TaskEditRequest request = new TaskEditRequest();
		request.setDateExecute(convertDateToString(task.getExecutionTime()));
		request.setDescription(task.getDescription());
		request.setId(task.getId());
		request.setName(task.getName());
		return request;
	}

}

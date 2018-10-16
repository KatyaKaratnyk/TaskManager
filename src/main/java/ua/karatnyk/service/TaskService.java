package ua.karatnyk.service;

import java.util.Date;
import java.util.List;
import ua.karatnyk.entity.TaskEntity;
import ua.karatnyk.entity.UserEntity;

public interface TaskService {
	List<TaskEntity> notDeleted(UserEntity userEntity);
	void save(TaskEntity task);
	TaskEntity findById(int id, UserEntity user);
	TaskEntity findById(int id);
	void update(String name, String description, Date date, int id);
	void update(int id);
}

package ua.karatnyk.service;

import ua.karatnyk.entity.UserEntity;

public interface UserService {
	
	void saveUser(UserEntity entity);
	
	UserEntity findUserByLogin(String login);
	
}

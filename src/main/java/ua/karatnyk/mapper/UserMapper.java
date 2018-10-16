package ua.karatnyk.mapper;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import ua.karatnyk.domain.UserAddRequest;
import ua.karatnyk.entity.UserEntity;
import ua.karatnyk.enums.Role;

public interface UserMapper {
	
	public static User toSecurityUser(UserEntity entity) {
		return new User(entity.getEmail(), entity.getPassword(), AuthorityUtils.createAuthorityList(String.valueOf(entity.getRole())));
	}
	
	
	public static UserEntity userAddRequestToUserEntity(UserAddRequest request) {
		UserEntity entity = new UserEntity();
		entity.setFirstName(request.getFirstName());
		entity.setLastName(request.getLastName());
		entity.setEmail(request.getEmail());
		entity.setPassword(request.getPassword());
		entity.setRole(Role.ROLE_USER);		
		return entity;
	}

}

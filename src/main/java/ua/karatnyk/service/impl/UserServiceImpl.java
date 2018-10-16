package ua.karatnyk.service.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.karatnyk.entity.UserEntity;
import ua.karatnyk.repository.UserRepository;
import ua.karatnyk.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public void saveUser(UserEntity entity) {
		String password = entity.getPassword();
		entity.setPassword(passwordEncoder.encode(password));
		userRepository.save(entity);
		
	}

	@Override
	public UserEntity findUserByLogin(String email) {
		return userRepository.findOne(new Specification<UserEntity>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate1 = cb.isFalse(root.get("isDeleted"));
				Predicate predicate2 = cb.equal(root.get("email"), email);
				return cb.and(predicate1, predicate2);
			}
		}).get();
	}	

}

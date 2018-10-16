package ua.karatnyk.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.karatnyk.entity.TaskEntity;
import ua.karatnyk.entity.UserEntity;
import ua.karatnyk.repository.TaskRepository;
import ua.karatnyk.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskRepository repository;

	@Override
	public List<TaskEntity> notDeleted(UserEntity userEntity) {
		return repository.findAll(new Specification<TaskEntity>() {
			
		
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<TaskEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate1 = cb.isFalse(root.get("isDeleted"));
				Predicate predicate2 = cb.isMember(userEntity, root.get("users"));
				return cb.and(predicate1, predicate2);
			}
		});
	}

	@Override
	public void save(TaskEntity task) {
		repository.save(task);
		
	}

	@Override
	public TaskEntity findById(int id, UserEntity user) {
		return repository.findOne(new Specification<TaskEntity>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<TaskEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate1 = cb.isFalse(root.get("isDeleted"));
				Predicate predicate2 = cb.isMember(user, root.get("users"));
				Predicate predicate3 = cb.equal(root.get("id"), id);
				return cb.and(predicate1, predicate2, predicate3);
			}
		}).orElse(null);
	}

	@Override
	@Transactional
	public void update(String name, String description, Date date, int id) {
		repository.update(name, description, date, id);
		
	}

	@Override
	@Transactional
	public void update(int id) {
		repository.update(id);
	}

	@Override
	public TaskEntity findById(int id) {
		return repository.findOne(new Specification<TaskEntity>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<TaskEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate1 = cb.isFalse(root.get("isDeleted"));
				Predicate predicate2 = cb.equal(root.get("id"), id);
				return cb.and(predicate1, predicate2);
			}
		}).orElse(null);
	}
	
}

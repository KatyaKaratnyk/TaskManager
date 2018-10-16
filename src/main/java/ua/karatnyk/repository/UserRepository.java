package ua.karatnyk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.karatnyk.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>, JpaSpecificationExecutor<UserEntity>{
	
	@Query("SELECT u FROM UserEntity u WHERE u.email = :email and u.isDeleted = false")
	UserEntity findUserByEmailAndActice(@Param("email") String email);
}

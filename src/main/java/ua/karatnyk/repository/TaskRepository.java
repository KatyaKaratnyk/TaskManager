package ua.karatnyk.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.karatnyk.entity.TaskEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer>, JpaSpecificationExecutor<TaskEntity>{
	
	@Modifying
	@Query("update TaskEntity t set t.name = :name, t.description = :description, t.executionTime = :executionTime where t.id = :id")
	void update(@Param("name") String name, @Param("description") String description, 
			@Param("executionTime") Date executionTime, @Param("id") int id);
	
	
	@Modifying
	@Query("update TaskEntity t set t.isDeleted = true where t.id = :id")
	void update( @Param("id") int id);
	
}

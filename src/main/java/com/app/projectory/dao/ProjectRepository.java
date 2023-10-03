package com.app.projectory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.projectory.dto.ProjectStatusCount;
import com.app.projectory.entity.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{
	/* for*/
	@Override
	List<Project> findAll();
	
	@Query(nativeQuery=true, value="SELECT STATUS as statusLabel, COUNT(STATUS) as labelCount FROM PROJECT "
			+ "GROUP BY STATUS ORDER BY statusLabel")
	List<ProjectStatusCount> countProjectStatus();
	
	@Query(value = "SELECT * FROM project p WHERE p.project_owner_user_id = ?1", nativeQuery = true)
	List<Project> findProjectListByUser(long userId); 
	
	
	
}
	
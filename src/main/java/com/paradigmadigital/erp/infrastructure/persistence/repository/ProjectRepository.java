package com.paradigmadigital.erp.infrastructure.persistence.repository;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.paradigmadigital.erp.infrastructure.persistence.entity.ProjectEntity;


@ApplicationScoped
public class ProjectRepository {

	   public ProjectEntity findById(Long id){
	       return null;
	   }
	   @Transactional
	   public void save(ProjectEntity entity){
	       
	   }
}

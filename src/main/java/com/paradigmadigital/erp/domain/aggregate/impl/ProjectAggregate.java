package com.paradigmadigital.erp.domain.aggregate.impl;

import com.paradigmadigital.erp.domain.aggregate.BaseAggregate;
import com.paradigmadigital.erp.domain.aggregate.IProjectAggregate;
import com.paradigmadigital.erp.domain.entity.ProjectEntity;


public class ProjectAggregate extends BaseAggregate implements IProjectAggregate{

	
	protected ProjectEntity projectEntity;
	
	public ProjectAggregate(ProjectEntity projectEntity) {
		super();
		this.projectEntity = projectEntity;
				
	}
	@Override
	public void createProject() {
		System.out.println("Intentnaod entrar");
		kieSession.insert(this.projectEntity);
		kieSession.fireAllRules();
		System.out.println("Ha ido bien");
	}

}

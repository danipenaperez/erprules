package com.paradigmadigital.erp.application.service;

import javax.enterprise.context.Dependent;

import com.paradigmadigital.erp.application.service.bean.ProjectBean;


public interface IProjectVacantService {

	public ProjectBean createProject();
	
	public ProjectBean findProject(Long id);
}

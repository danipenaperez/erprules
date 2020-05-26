package com.paradigmadigital.erp.application.service.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.paradigmadigital.erp.application.service.IProjectVacantService;
import com.paradigmadigital.erp.application.service.bean.ProjectBean;
import com.paradigmadigital.erp.domain.aggregate.IProjectVacantAggregate;
import com.paradigmadigital.erp.domain.entity.CandidateEntity;
import com.paradigmadigital.erp.domain.factory.AggregateFactory;
import com.paradigmadigital.erp.infrastructure.persistence.entity.ProjectEntity;
import com.paradigmadigital.erp.infrastructure.persistence.repository.ProjectRepository;

@ApplicationScoped
public class ProjectVacantService implements IProjectVacantService{

	Logger log = LoggerFactory.getLogger(this.getClass());
    
	@Inject
	AggregateFactory aggregateFactory;
	
	@Inject
	ProjectRepository projectRepository;
	
	private IProjectVacantAggregate proyectVacantAggregate;
	
	public ProjectBean createProject() {
		// TODO Auto-generated method stub
		
		log.info("atope creando");
		//log.info(this.proyectVacantAggregate.toString());
		proyectVacantAggregate = aggregateFactory.getProjectVacantAggregate();
		proyectVacantAggregate.addCanditate(new CandidateEntity());
		ProjectBean pb =  new ProjectBean("1", "fundacion lealtad");
		ProjectEntity pe = new ProjectEntity();
		pe.setId(Long.valueOf(pb.getId()));
		pe.setName(pb.getName());
		projectRepository.save(pe);
		return pb;
	}
	
	public ProjectBean findProject(Long id) {
		
		ProjectEntity pe = projectRepository.findById(id);
		System.out.println("he encontrado "+pe);
		ProjectBean pb =  new ProjectBean(pe.getId().toString(),pe.getName());
		return pb;
	}

}

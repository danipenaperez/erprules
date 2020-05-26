package com.paradigmadigital.erp.domain.factory;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.kie.kogito.rules.KieRuntimeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.paradigmadigital.erp.domain.aggregate.IProjectAggregate;
import com.paradigmadigital.erp.domain.aggregate.IProjectVacantAggregate;
import com.paradigmadigital.erp.domain.aggregate.impl.ProjectAggregate;
import com.paradigmadigital.erp.domain.entity.ProjectEntity;

@Singleton
public class AggregateFactory {
	Logger log = LoggerFactory.getLogger(this.getClass());
	@Inject
	private static KieRuntimeBuilder runtimeBuilder;
	
	public IProjectAggregate buildProjectAggregate(ProjectEntity pe) {
		log.info("el runtimerunner es "+ runtimeBuilder.toString());
		//ProjectAggregate pa = new ProjectAggregate(new ProjectEntity(0,"java",0,2));
		ProjectAggregate pa = new ProjectAggregate(pe);
		pa.setKieSession(runtimeBuilder.newKieSession());
		
		return pa;
	}
	
	public IProjectVacantAggregate getProjectVacantAggregate() {
		/**log.info("el runtimerunner es "+ runtimeBuilder.toString());
		ProjectVacantAggregate pa = new ProjectVacantAggregate(new ProyectEntity(0,"java",0,2), null);
		pa.setKieSession(runtimeBuilder.newKieSession());
		
		return pa;
		**/
		return null;
	}
	
	
	
}

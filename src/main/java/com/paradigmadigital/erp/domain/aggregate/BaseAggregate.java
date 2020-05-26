package com.paradigmadigital.erp.domain.aggregate;

import org.kie.api.runtime.KieSession;

/**
 * Base Class for all Aggregates,
 * Adds rule engine management for al Aggregate Objects
 * @author dpena
 *
 */
public class BaseAggregate {
	
	protected KieSession kieSession;
	
	public void setKieSession(KieSession kieSession) {
		this.kieSession = kieSession;
	}
	
}

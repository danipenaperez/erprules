package com.paradigmadigital.erp.domain.aggregate;

import com.paradigmadigital.erp.domain.entity.CandidateEntity;
import com.paradigmadigital.erp.domain.event.BaseDomainEvent;

public interface IProjectVacantAggregate {

	public Boolean addCanditate(CandidateEntity canditate);
	
	public BaseDomainEvent onEvent();
}

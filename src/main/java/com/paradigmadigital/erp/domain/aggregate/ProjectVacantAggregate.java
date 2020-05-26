package com.paradigmadigital.erp.domain.aggregate;

public class ProjectVacantAggregate {//extends BaseAggregate implements IProjectVacantAggregate{
/**
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	private ProyectEntity proyect;
	private List<CandidateEntity> candidates;
	
	
 
    public ProjectVacantAggregate(ProyectEntity proyect, List<CandidateEntity> candidates) {
		super();
		this.proyect = proyect;
		this.candidates = candidates;
	}



	public Boolean addCanditate(CandidateEntity canditate) {
		
		log.info("alla voy " +this.kieSession);
		log.info(this.proyect.toString());
		
		log.info(this.toString());
		ProyectEntity pe = new ProyectEntity(0, "java", 3, 0);
		kieSession.insert(this.proyect);
		kieSession.fireAllRules();
//        this.ksession.insert(canditate);
//        this.ksession.fireAllRules();
		log.info("pues a ido bien");
		log.info(this.proyect.getName());
        return true;
 
    }



	public ProyectEntity getProyect() {
		return proyect;
	}



	public void setProyect(ProyectEntity proyect) {
		this.proyect = proyect;
	}



	public List<CandidateEntity> getCandidates() {
		return candidates;
	}



	public void setCandidates(List<CandidateEntity> candidates) {
		this.candidates = candidates;
	}



	public BaseDomainEvent onEvent() {
		// TODO Auto-generated method stub
		return null;
	}
	
	**/
}

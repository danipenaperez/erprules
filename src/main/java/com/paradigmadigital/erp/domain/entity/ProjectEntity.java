package com.paradigmadigital.erp.domain.entity;

public class ProjectEntity {

	private Integer id;
	private String name;
	private Integer numberOfVacants;
	private Integer numberOfVacantsAssigned;//already assigned
	
	public ProjectEntity() {
		super();
	}
	
	public ProjectEntity(Integer id, String name, Integer numberOfVacants, Integer numberOfVacantsAssigned) {
		super();
		this.id = id;
		this.name = name;
		this.numberOfVacants = numberOfVacants;
		this.numberOfVacantsAssigned = numberOfVacantsAssigned;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumberOfVacants() {
		return numberOfVacants;
	}
	public void setNumberOfVacants(Integer numberOfVacants) {
		this.numberOfVacants = numberOfVacants;
	}
	public Integer getNumberOfVacantsAssigned() {
		return numberOfVacantsAssigned;
	}
	public void setNumberOfVacantsAssigned(Integer numberOfVacantsAssigned) {
		this.numberOfVacantsAssigned = numberOfVacantsAssigned;
	}
	
}

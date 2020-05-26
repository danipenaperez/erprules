package com.paradigmadigital.erp.application.service.bean;

public class ProjectBean {

	public ProjectBean() {
		super();
	}
	public ProjectBean(String id, String name) {
		this.id = id;
		this.name = name;
	}
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ProjectBean [id=" + id + ", name=" + name + "]";
	}
	
	
}

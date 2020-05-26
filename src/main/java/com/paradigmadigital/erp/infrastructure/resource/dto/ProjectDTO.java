package com.paradigmadigital.erp.infrastructure.resource.dto;

import com.paradigmadigital.erp.infrastructure.persistence.entity.ProjectEntity;

import io.vertx.mutiny.sqlclient.Row;

public class ProjectDTO {

    private Long id;

    private String name;

    private final String type = ProjectDTO.class.getName();

	public ProjectDTO() {
		super();
	}
    

	public ProjectDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	



	public String getType() {
		return type;
	}


	@Override
	public String toString() {
		return "ProjectDTO [id=" + id + ", name=" + name + "]";
	}
}

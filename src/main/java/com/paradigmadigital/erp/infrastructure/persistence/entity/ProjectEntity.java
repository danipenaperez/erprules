package com.paradigmadigital.erp.infrastructure.persistence.entity;

import io.vertx.mutiny.sqlclient.Row;

public class ProjectEntity {

    
    private Long id;

    private String name;
    

	public ProjectEntity() {
		super();
	}
    
    
    public static ProjectEntity from(Row row) {
        return new ProjectEntity(row.getLong("id"), row.getString("name"));
    }




	public ProjectEntity(Long id, String name) {
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


	@Override
	public String toString() {
		return "ProjectEntity [id=" + id + ", name=" + name + "]";
	}



	
}

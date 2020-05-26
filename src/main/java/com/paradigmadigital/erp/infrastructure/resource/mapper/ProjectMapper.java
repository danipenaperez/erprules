package com.paradigmadigital.erp.infrastructure.resource.mapper;

import org.mapstruct.Mapper;

import com.paradigmadigital.erp.application.service.bean.ProjectBean;
import com.paradigmadigital.erp.domain.entity.ProjectEntity;
import com.paradigmadigital.erp.infrastructure.resource.dto.ProjectDTO;

@Mapper(config = QuarkusMappingConfig.class)
public interface ProjectMapper {

	
	ProjectDTO toDTO(ProjectBean pb);
	//IF needed 
	//@Mapping(source = "propertyName", target = "propertyName")
	ProjectBean toBean(ProjectDTO pb);
	
	
	ProjectEntity toEntity(ProjectBean pb);
}

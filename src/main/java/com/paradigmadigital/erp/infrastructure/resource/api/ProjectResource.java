package com.paradigmadigital.erp.infrastructure.resource.api;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.paradigmadigital.erp.application.service.impl.ProyectVacantReactiveService;
import com.paradigmadigital.erp.infrastructure.persistence.entity.ProjectEntity;
import com.paradigmadigital.erp.infrastructure.resource.dto.ProjectDTO;
import com.paradigmadigital.erp.infrastructure.resource.mapper.ProjectMapper;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/project")
public class ProjectResource {
 
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Context
    UriInfo uriInfo;
	
	//@Inject
	//io.opentracing.Tracer tracer;
	
	@Inject
	private ProjectMapper projectMapper;
	
	@Inject
	private ProyectVacantReactiveService proyectVacantReactiveService;

	
	@POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	@Operation(
	    summary = "Get all Posts",
	    description = "Get all posts"
	)
	@APIResponse(
	    responseCode = "200",
	    name = "Post list",
	    content = @Content(
	        mediaType = "application/json",
	        schema = @Schema(
	            type = SchemaType.ARRAY,
	            implementation = ProjectEntity.class
	        )
	    )
	)
    public Uni<Response>  save(ProjectDTO dto) {
    	log.info("entrando Salvando" );
    	return proyectVacantReactiveService.save(projectMapper.toBean(dto)).onItem().apply(id -> URI.create("/project/" + id))
                .onItem().apply(uri -> Response.created(uri).build());
    }
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Multi<ProjectDTO>  getAll() {
    	log.info("entrando buscando todo" );
    	return proyectVacantReactiveService.findAll().map(item -> new ProjectDTO(item.getId(), item.getName()));
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<ProjectDTO>  getBydId(@PathParam("id") Long id) {
    	log.info("entrando buscando todo" );
    	return proyectVacantReactiveService.findById(id).map(item -> new ProjectDTO(item.getId(), item.getName()));
    }
    
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<Response>  updateBydId(@PathParam("id") Long id, ProjectDTO Pdto) {
    	log.info("entrando buscando todo  "+ Pdto );
    	Pdto.setId(id);
    	return proyectVacantReactiveService.update(projectMapper.toBean(Pdto))
    			.onItem().apply(updated -> updated ? Status.OK : Status.NOT_FOUND)
    			.onItem().apply(status -> Response.status(status).build());
    }
    
    @DELETE
    @Path("{id}")
    public Uni<Response> delete(@PathParam("id") Long id) {
        return proyectVacantReactiveService.delete(id)
                .onItem().apply(deleted -> deleted ? Status.NO_CONTENT : Status.NOT_FOUND)
                .onItem().apply(status -> Response.status(status).build());
    }
    
    
    /**
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProject(@PathParam("id")Long id) {
    	log.info("entrando xcvbxc" );
    	ProjectBean found = proyectServices.findProject(id);
    	log.info("retorna " +found);
    	return found.toString();
 
    }
    **/
}
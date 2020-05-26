package com.paradigmadigital.erp.application.service.impl;

import java.util.stream.StreamSupport;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.paradigmadigital.erp.application.service.bean.ProjectBean;
import com.paradigmadigital.erp.domain.aggregate.IProjectAggregate;
import com.paradigmadigital.erp.domain.factory.AggregateFactory;
import com.paradigmadigital.erp.infrastructure.persistence.entity.ProjectEntity;
import com.paradigmadigital.erp.infrastructure.resource.mapper.ProjectMapper;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.sqlclient.RowSet;
import io.vertx.mutiny.sqlclient.Tuple;

@ApplicationScoped
public class ProyectVacantReactiveService{

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Inject
	private ProjectMapper projectMapper;
	
	@Inject
	AggregateFactory aggregateFactory;
	
	
	@PostConstruct
    void initDatabase() {
		
		client.query("DROP TABLE IF EXISTS projectEntity")
        .flatMap(r -> client.query("CREATE TABLE projectEntity (id SERIAL PRIMARY KEY, name TEXT NOT NULL)"))
        .flatMap(r -> client.query("INSERT INTO projectEntity (name) VALUES ('Kiwi')"))
        .flatMap(r -> client.query("INSERT INTO projectEntity (name) VALUES ('Durian')"))
        .flatMap(r -> client.query("INSERT INTO projectEntity (name) VALUES ('Pomelo')"))
        .flatMap(r -> client.query("INSERT INTO projectEntity (name) VALUES ('Lychee')"))
        .await().indefinitely();
        
    }
	
	
	@Inject
    private io.vertx.mutiny.pgclient.PgPool client;

	
	

    public Multi<ProjectEntity> findAll() {
        return client.query("SELECT id, name FROM projectEntity ORDER BY name ASC")
                .onItem().produceMulti(set -> Multi.createFrom().items(() -> StreamSupport.stream(set.spliterator(), false)))
                .onItem().apply(ProjectEntity::from);
    }
	
    public Uni<ProjectEntity> findById( Long id) {
        return client.preparedQuery("SELECT id, name FROM projectEntity WHERE id = $1", Tuple.of(id))
                .onItem().apply(RowSet::iterator)
                .onItem().apply(iterator -> iterator.hasNext() ? ProjectEntity.from(iterator.next()) : null);
    }
    public Uni<Long> save(ProjectBean pb) {
    	System.out.println("lelga pb "+ pb);
    	//1.First process Rules
    	IProjectAggregate pa = aggregateFactory.buildProjectAggregate(projectMapper.toEntity(pb));
    	pa.createProject();
        return client.preparedQuery("INSERT INTO projectEntity (name) VALUES ($1) RETURNING (id)", Tuple.of(pb.getName()))
                .onItem().apply(pgRowSet -> pgRowSet.iterator().next().getLong("id"));
    }
    
    public Uni<Boolean> update(ProjectBean pb) {
        return client.preparedQuery("UPDATE projectEntity SET name = $1 WHERE id = $2", Tuple.of(pb.getName(), pb.getId()))
                .onItem().apply(pgRowSet -> pgRowSet.rowCount() == 1);
    }


    public  Uni<Boolean> delete( Long id) {
        return client.preparedQuery("DELETE FROM projectEntity WHERE id = $1", Tuple.of(id))
                .onItem().apply(pgRowSet -> pgRowSet.rowCount() == 1);
    }

	public ProjectBean findProject(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}

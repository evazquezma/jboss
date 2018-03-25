package es.sisifo.jboss.datasources.dao;

import java.util.List;

import es.sisifo.jboss.datasources.entity.one.EntityOne;

public interface EntityOneDao {

	EntityOne save(EntityOne entity);

	List<EntityOne> getAll();

}

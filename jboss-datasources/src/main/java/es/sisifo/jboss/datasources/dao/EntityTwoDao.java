package es.sisifo.jboss.datasources.dao;

import java.util.List;

import es.sisifo.jboss.datasources.entity.two.EntityTwo;

public interface EntityTwoDao {

	EntityTwo save(EntityTwo entity);

	List<EntityTwo> getAll();
}

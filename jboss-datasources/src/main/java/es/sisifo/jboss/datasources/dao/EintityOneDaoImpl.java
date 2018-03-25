package es.sisifo.jboss.datasources.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import es.sisifo.jboss.datasources.entity.one.EntityOne;

@Repository
public class EintityOneDaoImpl implements EntityOneDao {

	@Autowired @Qualifier("sessionFactory1")
	private SessionFactory sessionFactory;

	@Override
	public EntityOne save(final EntityOne entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EntityOne> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(EntityOne.class).list();
	}
}

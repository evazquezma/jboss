package es.sisifo.jboss.datasources.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import es.sisifo.jboss.datasources.entity.two.EntityTwo;

@Repository
public class EintityTwoDaoImpl implements EntityTwoDao {

	@Autowired @Qualifier("sessionFactory2")
	private SessionFactory sessionFactory;

	@Override
	public EntityTwo save(final EntityTwo entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EntityTwo> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(EntityTwo.class).list();
	}
}

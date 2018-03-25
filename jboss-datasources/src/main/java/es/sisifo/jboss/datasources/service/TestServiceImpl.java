package es.sisifo.jboss.datasources.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sisifo.jboss.datasources.dao.EntityOneDao;
import es.sisifo.jboss.datasources.dao.EntityTwoDao;
import es.sisifo.jboss.datasources.entity.one.EntityOne;
import es.sisifo.jboss.datasources.entity.two.EntityTwo;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private EntityOneDao entityOneDao;

	@Autowired
	private EntityTwoDao entityTwoDao;


	@Override
	@Transactional
	public void testInsertOK() {
		final EntityOne entityOne = new EntityOne();
		entityOne.setTime(new Date());
		entityOne.setCode("Insert OK");
		entityOneDao.save(entityOne);

		final EntityTwo entityTwo = new EntityTwo();
		entityTwo.setTime(new Date());
		entityTwo.setCode("Insert OK");
		entityTwoDao.save(entityTwo);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void testInsertMiddleError() {
		final EntityOne entityOne = new EntityOne();
		entityOne.setTime(new Date());
		entityOne.setCode("Insert with Middle Error");
		entityOneDao.save(entityOne);

		if (System.currentTimeMillis() > 0) {
			throw new RuntimeException("Kaboom in the middle");
		}

		final EntityTwo entityTwo = new EntityTwo();
		entityTwo.setTime(new Date());
		entityTwo.setCode("Insert with Middle Error");
		entityTwoDao.save(entityTwo);
	}


	@Override
	@Transactional(rollbackFor=Exception.class)
	public void testInsertFinalError() {
		final EntityOne entityOne = new EntityOne();
		entityOne.setTime(new Date());
		entityOne.setCode("Insert with Final Error");
		entityOneDao.save(entityOne);

		final EntityTwo entityTwo = new EntityTwo();
		entityTwo.setTime(new Date());
		entityTwo.setCode("Insert with Final Error");
		entityTwoDao.save(entityTwo);

		throw new RuntimeException("Kaboom at the end");
	}

	@Override
	@Transactional
	public List<EntityOne> getAllOne() {
		return entityOneDao.getAll();
	}

	@Override
	@Transactional
	public List<EntityTwo> getAllTwo() {
		return entityTwoDao.getAll();
	}

}

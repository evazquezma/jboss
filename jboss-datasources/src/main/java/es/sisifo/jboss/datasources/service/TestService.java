package es.sisifo.jboss.datasources.service;

import java.util.List;

import es.sisifo.jboss.datasources.entity.one.EntityOne;
import es.sisifo.jboss.datasources.entity.two.EntityTwo;

public interface TestService {

	void testInsertOK();

	void testInsertMiddleError();

	void testInsertFinalError();

	List<EntityOne> getAllOne();

	List<EntityTwo> getAllTwo();


}

package es.sisifo.jboss.monitor.service;

import java.util.List;

public interface DomainService {
	/**
	 * List all nodes in the domain
	 * @return
	 */
	List<String> getNodes();

}

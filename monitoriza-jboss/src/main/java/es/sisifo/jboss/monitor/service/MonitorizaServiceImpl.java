package es.sisifo.jboss.monitor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("monitorizaService")
public class MonitorizaServiceImpl implements MonitorizaService {
	@Autowired
	private DomainService domainService;

	@Override
	public void run() {
		domainService.getNodes();
	}

}

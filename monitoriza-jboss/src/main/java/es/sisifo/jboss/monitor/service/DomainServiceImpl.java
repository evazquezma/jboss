package es.sisifo.jboss.monitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sisifo.jboss.monitor.modelo.commands.impl.ListNodesCliCommand;

@Service("domainService")
public class DomainServiceImpl implements DomainService {

	@Autowired
	private CliConnection connection;

	@Override
	public List<String> getNodes() {
		connection.runCommand(new ListNodesCliCommand());
		return null;
	}

}

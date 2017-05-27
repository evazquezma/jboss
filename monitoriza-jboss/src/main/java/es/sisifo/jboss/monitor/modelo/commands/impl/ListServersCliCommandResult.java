package es.sisifo.jboss.monitor.modelo.commands.impl;

import java.util.Collections;
import java.util.List;

import es.sisifo.jboss.monitor.modelo.commands.CliCommandResult;

public class ListServersCliCommandResult implements CliCommandResult {
	private final List<String> serverNames;

	public ListServersCliCommandResult(final List<String> serverNames) {
		this.serverNames = serverNames;
	}


	public List<String> getServerNames() {
		return Collections.unmodifiableList(serverNames);
	}
}

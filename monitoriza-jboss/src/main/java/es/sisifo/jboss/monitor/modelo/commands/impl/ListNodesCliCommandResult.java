package es.sisifo.jboss.monitor.modelo.commands.impl;

import java.util.Collections;
import java.util.List;

import es.sisifo.jboss.monitor.modelo.commands.CliCommandResult;

public class ListNodesCliCommandResult implements CliCommandResult {
	private final List<String> nodeNames;

	public ListNodesCliCommandResult(final List<String> nodeNames) {
		this.nodeNames = nodeNames;
	}


	public List<String> getNodeNames() {
		return Collections.unmodifiableList(nodeNames);
	}
}

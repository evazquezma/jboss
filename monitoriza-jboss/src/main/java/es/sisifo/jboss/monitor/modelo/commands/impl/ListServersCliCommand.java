package es.sisifo.jboss.monitor.modelo.commands.impl;

import java.util.List;

import org.jboss.as.cli.scriptsupport.CLI.Result;

import es.sisifo.jboss.monitor.modelo.commands.CliCommand;
import es.sisifo.jboss.monitor.modelo.commands.CliCommandResult;
import es.sisifo.jboss.monitor.modelo.commands.util.CliCommandResultUtil;

public class ListServersCliCommand implements CliCommand {
	private final String nodeName;

	public ListServersCliCommand(final String nodeName) {
		this.nodeName = nodeName;
	}

	@Override
	public String getCommand() {
		return String.format("host=%s/:read-children-names(child-type=server)", nodeName);
	}

	@Override
	public CliCommandResult buildResult(final Result result) {
		final List<String> nodeNames = CliCommandResultUtil.parseListResult(result);
		return new ListNodesCliCommandResult(nodeNames);
	}

}

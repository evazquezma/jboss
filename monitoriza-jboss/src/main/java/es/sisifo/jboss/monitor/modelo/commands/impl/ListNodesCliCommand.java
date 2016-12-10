package es.sisifo.jboss.monitor.modelo.commands.impl;

import org.jboss.as.cli.scriptsupport.CLI.Result;

import es.sisifo.jboss.monitor.modelo.commands.CliCommand;
import es.sisifo.jboss.monitor.modelo.commands.CliCommandResult;

public class ListNodesCliCommand implements CliCommand{

	@Override
	public String getCommand() {
		return "ls /host";
	}

	@Override
	public CliCommandResult buildResult(final Result result) {
		return null;
	}

}

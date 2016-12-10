package es.sisifo.jboss.monitor.modelo.commands;

import org.jboss.as.cli.scriptsupport.CLI.Result;

public interface CliCommand {
	String getCommand();

	CliCommandResult buildResult(Result result);
}

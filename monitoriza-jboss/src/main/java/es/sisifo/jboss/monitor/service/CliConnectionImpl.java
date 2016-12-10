package es.sisifo.jboss.monitor.service;

import javax.annotation.PreDestroy;

import org.jboss.as.cli.scriptsupport.CLI;
import org.jboss.as.cli.scriptsupport.CLI.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.sisifo.jboss.monitor.modelo.commands.CliCommand;
import es.sisifo.jboss.monitor.modelo.commands.CliCommandResult;

public class CliConnectionImpl implements CliConnection {
	private static final Logger LOGGER = LoggerFactory.getLogger(CliConnectionImpl.class);

	private final CLI cli;

	public CliConnectionImpl(final CLI cli) {
		this.cli = cli;
	}

	@PreDestroy
	public void destroy() {
		cli.disconnect();
	}


	@Override
	public CliCommandResult runCommand (final CliCommand command) {
		final String commandString = command.getCommand();
		LOGGER.debug("Running command {}", commandString);
		final Result result = cli.cmd(commandString);
		LOGGER.debug("Command {}. Result {}", commandString, result);
		return command.buildResult(result);
	}
}

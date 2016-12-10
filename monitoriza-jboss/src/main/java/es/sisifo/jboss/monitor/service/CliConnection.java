package es.sisifo.jboss.monitor.service;

import es.sisifo.jboss.monitor.modelo.commands.CliCommand;
import es.sisifo.jboss.monitor.modelo.commands.CliCommandResult;

public interface CliConnection {

	CliCommandResult runCommand(CliCommand command);

}
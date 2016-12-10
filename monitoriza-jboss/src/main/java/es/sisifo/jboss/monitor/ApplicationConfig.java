package es.sisifo.jboss.monitor;

import org.jboss.as.cli.scriptsupport.CLI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import es.sisifo.jboss.monitor.service.CliConnection;
import es.sisifo.jboss.monitor.service.CliConnectionImpl;

@Configuration
public class ApplicationConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfig.class);

	@Value("${conf.domainController.host}")
	private String domainController;

	@Value("${conf.domainController.port}")
	private Integer domainControllerPort;

	@Value("${conf.domainController.usuario:}")
	private String usuario;

	@Value("${conf.domainController.password:}")
	private String password;


	@Bean
	public CliConnection cliConnection() {
		final CLI cli = CLI.newInstance();
		if (StringUtils.hasLength(usuario) && StringUtils.hasLength(password)) {
			LOGGER.info("Conectando a domain controller {}:{} con credenciales...", domainController, domainControllerPort);
			cli.connect(domainController, domainControllerPort, usuario, password.toCharArray());
		}
		else {
			LOGGER.info("Conectando a domain controller {}:{} sin credenciales...", domainController, domainControllerPort);
			cli.connect(domainController, domainControllerPort, null, null);
		}

		return new CliConnectionImpl(cli);
	}
}

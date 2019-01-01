package es.pruebas.sisifo;

import java.util.Properties;

import javax.naming.NamingException;
import javax.naming.NoInitialContextException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.jndi.JndiTemplate;

@Configuration
public class PropertiesConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesConfig.class);

	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(final Properties customProperties) {
		final PropertySourcesPlaceholderConfigurer placeHolder = new PropertySourcesPlaceholderConfigurer();
		placeHolder.setProperties(customProperties);
		return placeHolder;
	}

	@Bean(name = "customProperties")
	public PropertiesFactoryBean customProperties() throws NamingException {
		final PropertiesFactoryBean factory = new PropertiesFactoryBean();
		factory.setLocations(propertiesResources());
		return factory;
	}

	@Bean(name = "propertiesResources")
	public Resource[] propertiesResources() throws NamingException {
		final Resource resourceConfProperties = new ClassPathResource("conf.properties");

		try {
			final Resource resourceExterno = new FileSystemResource((String) new JndiTemplate().lookup("java:/es/pruebas/sisifo/simpleBoot-Jboss/configuration-properties-location"));
			return new Resource[] {resourceConfProperties, resourceExterno};
		}
		catch(final NoInitialContextException e) {
			LOGGER.warn("JNDI Context not found", e);
			return new Resource[] {resourceConfProperties};
		}
	}

}

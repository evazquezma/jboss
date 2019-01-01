package es.pruebas.sisifo;

import java.util.Properties;

import javax.naming.NamingException;

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

	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(final Properties customProperties) {
		final PropertySourcesPlaceholderConfigurer placeHolder = new PropertySourcesPlaceholderConfigurer();
		placeHolder.setProperties(customProperties);
		return placeHolder;
	}


	@Bean(name="customProperties")
	public PropertiesFactoryBean customProperties() throws NamingException{
		final Resource resourceConfProperties = new ClassPathResource("conf.properties");
		final Resource resourceExterno = new FileSystemResource((String)new JndiTemplate().lookup("java:/es/pruebas/sisifo/simpleBoot-Jboss/configuration-properties-location"));

		final PropertiesFactoryBean factory = new PropertiesFactoryBean();
		factory.setLocations(resourceConfProperties, resourceExterno);
		return factory;
	}



}

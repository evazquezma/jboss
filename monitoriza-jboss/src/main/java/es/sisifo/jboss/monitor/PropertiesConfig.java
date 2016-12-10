package es.sisifo.jboss.monitor;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@Configuration
@PropertySources({
	@PropertySource("classpath:conf.properties"),
    @PropertySource(value = "file:${configFile}", ignoreResourceNotFound = false)
})
public class PropertiesConfig {

//	@Bean
//	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//		return new PropertySourcesPlaceholderConfigurer();
//	}
//
//
//	@Bean(name="properties")
//	public PropertiesFactoryBean properties() throws NamingException{
//		final Resource resourceConfProperties = new ClassPathResource("conf.properties");
//		final Resource resourceExterno = new FileSystemResource("file:${configFile}");
//
//		final PropertiesFactoryBean factory = new PropertiesFactoryBean();
//		factory.setLocations(resourceConfProperties, resourceExterno);
//		return factory;
//	}
}

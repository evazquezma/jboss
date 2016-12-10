package es.sisifo.jboss.monitor;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import es.sisifo.jboss.monitor.service.MonitorizaService;


@EnableAsync
@Configuration
@ComponentScan(basePackages = { "es.sisifo.jboss.monitor" })
@EnableAutoConfiguration
// The @SpringBootApplication annotation is equivalent to using @Configuration,
// @EnableAutoConfiguration and @ComponentScan with their default attributes:
public class Application {

    public static void main(final String[] args) {
    	final ApplicationContext ctx = new SpringApplicationBuilder(Application.class).web(false).run(args);
    	final MonitorizaService monitorizaService = ctx.getBean(MonitorizaService.class);
    	monitorizaService.run();

//        final ApplicationContext ctx = SpringApplication.run(Application.class, args);

    }

}
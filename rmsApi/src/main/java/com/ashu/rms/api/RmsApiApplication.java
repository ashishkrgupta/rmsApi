package com.ashu.rms.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.ashu.rms.api.config.PropertyPasswordInitializer;

/**
 * this class is entry point of the application
 * @author ashu
 *
 */
@SuppressWarnings("deprecation")
@ComponentScan
@SpringBootApplication
public class RmsApiApplication extends SpringBootServletInitializer {
	final static String CONFIG_LOC = "/Users/ashu/Documents/config/";
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(RmsApiApplication.class);
		Set<ApplicationContextInitializer<?>> initializers = app.getInitializers();
		initializers.add(new PropertyPasswordInitializer());
		app.setInitializers(initializers);
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("spring.config.location", CONFIG_LOC);
		app.setDefaultProperties(properties);
		ApplicationContext ctx = app.run(args);
		if (ctx.getEnvironment().getActiveProfiles() != null){
			for (String profile : ctx.getEnvironment().getActiveProfiles()){
				System.out.println("Active profile : " + profile);
			}
		}
		for (String beanName : ctx.getBeanDefinitionNames()){
			System.out.println(beanName);
		}
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		builder.initializers(new PropertyPasswordInitializer());
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("spring.config.location", CONFIG_LOC);
		builder.properties(properties);
		return builder.sources(RmsApiApplication.class);
	}
	
	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}
}

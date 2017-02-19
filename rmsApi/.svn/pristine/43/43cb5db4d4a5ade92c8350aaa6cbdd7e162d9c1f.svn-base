package com.ashu.rms.api.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

public class PropertyPasswordInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	public void initialize(ConfigurableApplicationContext ctx) {
		ConfigurableEnvironment env = ctx.getEnvironment();
		for (String profile : env.getActiveProfiles()){
			System.out.println("Active profiles " + profile);
		}
		Map<String, Object> propOvrds = new HashMap<String, Object>();
		Map<String, Object> appProp = new HashMap<String, Object>();
		for (PropertySource<?> ps : env.getPropertySources()){
			if (ps.getName().contains("test.yml") || ps.getName().equalsIgnoreCase("applicationConfigurationProperties")){
				appProp = getProperties(ps);
				System.out.println(ps.getSource());
			}
			System.out.println("property name " + ps.getName());
			decodePassword(ps, propOvrds);
		}
		if (!propOvrds.isEmpty()){
			PropertySource<?> decodedMap = new MapPropertySource("decodedProperties", propOvrds);
			env.getPropertySources().addFirst(decodedMap);
			appProp.putAll(propOvrds);
		}
	}

	private Map<String, Object> getProperties(PropertySource<?> ps) {
		Map<String, Object> props = new HashMap<String, Object>();
		if (ps instanceof EnumerablePropertySource){
			EnumerablePropertySource<?> eps = (EnumerablePropertySource<?>) ps;
			for (String key : eps.getPropertyNames()){
				Object rawVal = ps.getProperty(key);
				props.put(key, rawVal);
				if (key.equalsIgnoreCase("spring.config.location")){
					System.out.println("Key : " + key + ", Value : " + rawVal);
				}
				
			}
		} 
		return props;
	}

	private void decodePassword(PropertySource<?> ps, Map<String, Object> propOvrds) {
		if (ps instanceof EnumerablePropertySource){
			EnumerablePropertySource<?> eps = (EnumerablePropertySource<?>) ps;
			for (String key : eps.getPropertyNames()){
				Object rawVal = ps.getProperty(key);
				if (key.equalsIgnoreCase("spring.config.location")){
					System.out.println("Key : " + key + ", Value : " + rawVal);
				}
				if (rawVal instanceof String && key.contains("encrypted")){
					String decodedVal = getDecryptedString((String)rawVal);
					String decodedKey = key.replace("encrypted.", "");
					propOvrds.put(decodedKey, decodedVal);
				}
			}
		} else if (ps instanceof CompositePropertySource){
			for (PropertySource<?> nestedPs : ((CompositePropertySource)ps).getPropertySources()){
				decodePassword(nestedPs, propOvrds);
			}
		}
	}

	private String getDecryptedString(String rowVal) {
		return Descrambler.decode(rowVal);
	}

}

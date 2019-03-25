/*package com.sg.eportal;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import com.google.common.base.Strings;


*//**
 * Sets spring.profiles.active system property when no spring.profiles.active argument is passed in jvm startup arguments 
 * 
 * @author 501990198
 *
 *//*
public class ContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	public void initialize(ConfigurableApplicationContext context) {
		
		ConfigurableEnvironment environment = context.getEnvironment();
		System.setProperty("spring.profiles.active",Strings.nullToEmpty(environment.getProperty("spring.profiles.active")));
		
	}

}
*/
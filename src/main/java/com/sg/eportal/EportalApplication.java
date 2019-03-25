package com.sg.eportal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication 
//(exclude = {org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class })
@MapperScan("com.sg.eportal.mapper")
@EnableAsync
//@EnableWebSecurity
public class EportalApplication extends SpringBootServletInitializer  {
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EportalApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(EportalApplication.class, args);
	}

}

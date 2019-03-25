package com.sg.eportal;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfiguration {
	
	  /*@Bean(name = "datasource1")
	    @ConfigurationProperties("spring.datasource")	   
	    public DataSource dataSource(){
	        return DataSourceBuilder.create().build();
	    }*/

	    @Bean(name = "datasource2")
	    @Primary
	    @ConfigurationProperties("spring.datasource2")
	    public DataSource dataSource2(){
	        return DataSourceBuilder.create().build();
	    }

}

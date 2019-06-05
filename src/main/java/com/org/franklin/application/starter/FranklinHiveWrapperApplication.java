package com.org.franklin.application.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.apache.log4j.Logger;
/*******************************************************************************
 * Copyright (c) 2019  Infosys Ltd. All rights reserved.
 * 
 *  Contributors:
 *      Samrat Basu.
 *      May 27, 2019
 ******************************************************************************/
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"com.org.franklin"})
@EnableJpaRepositories( basePackages = "com.org.franklin.dao")
@EntityScan("com.org.franklin.entity")
public class FranklinHiveWrapperApplication {
	private final static Logger log = Logger.getLogger(FranklinHiveWrapperApplication.class);
	
	public static void main(String[] args) {
		log.debug("Hive Wrapper Started...");
		SpringApplication.run(FranklinHiveWrapperApplication.class, args);
	}

}

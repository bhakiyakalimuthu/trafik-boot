package com.challenge.trafikboot;

import com.challenge.trafikboot.config.ConfigProperties;
import com.challenge.trafikboot.config.ServicePublicWebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@EnableAutoConfiguration
@Import({ServicePublicWebConfig.class, ConfigProperties.class})
public class TrafikBootApplication {

	public static void main(String[] args) {

		SpringApplication.run(TrafikBootApplication.class, args);
	}


}

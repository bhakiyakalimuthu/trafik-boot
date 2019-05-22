package com.challenge.trafikboot.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author : Bhakiyaraj Kalimuthu
 * @date : 2019-05-17
 */

@Configuration
@ComponentScan(basePackages = {"com.challenge.trafikboot.rest", "com.challenge.trafikboot.service", "com.challenge.trafikboot.component"})
@EnableWebMvc
@EnableCaching
public class ServicePublicWebConfig {

	private static final int CONNECTION_TIMEOUT = 1000;
	private static final int READ_TIMEOUT = 5000;

	@Bean(name = "restrictedJsonRestTemplate")
	public RestTemplate promotionServiceRestTemplate() {
		return new RestTemplateBuilder()
				.setConnectTimeout(CONNECTION_TIMEOUT)
				.setReadTimeout(READ_TIMEOUT)
				.messageConverters(new GsonHttpMessageConverter())
				.build();
	}
}

package com.challenge.trafikboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : Bhakiyaraj Kalimuthu
 * @date : 2019-05-17
 */

@Component
@ConfigurationProperties("request")
public class ConfigProperties {

	private String baseUrl;
	private String key;

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}

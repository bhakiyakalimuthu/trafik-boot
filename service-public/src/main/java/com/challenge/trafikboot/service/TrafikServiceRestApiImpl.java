package com.challenge.trafikboot.service;

import com.challenge.trafikboot.exception.TrafikBootRuntimeException;
import com.challenge.trafikboot.rest.model.response.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;

import static java.util.Collections.singletonList;

/**
 * @author : Bhakiyaraj Kalimuthu
 * @date : 2019-05-17
 */
@Service
public class TrafikServiceRestApiImpl implements TrafikServiceRestApi {

	private static final Logger LOG = LoggerFactory.getLogger(TrafikServiceRestApiImpl.class);
	private RestTemplate gsonRestTemplate;

	@Autowired
	public TrafikServiceRestApiImpl(RestTemplate gsonRestTemplate) {
		this.gsonRestTemplate = new RestTemplate(singletonList(new GsonHttpMessageConverter()));
	}

	/**
	 * Rest class to make rest request and map the response to gson rest template.
	 */

	@Override
	public ApiResponse makeRequest(UriComponents requestURI) {

		return requestForEntityWithExceptionHandling(requestURI);
	}

	private ApiResponse requestForEntityWithExceptionHandling(UriComponents requestURI){

		try {
			ApiResponse response = gsonRestTemplate.getForObject(requestURI.toUri(), ApiResponse.class);
			return response;
		}catch (HttpClientErrorException e) {
			LOG.error(String.format("HttpClientErrorException caught when trying to make rest call [requestUri=%s],[exception=%s]",requestURI,e.toString()));
			throw new TrafikBootRuntimeException(String.format("HttpClientErrorException caught when trying to make rest call [requestUri=%s],[exception=%s]",requestURI,e.toString()));
		}catch (HttpStatusCodeException e) {
			LOG.error(String.format("HttpStatusCodeException caught when trying to make rest call [requestUri=%s],[exception=%s]",requestURI,e.toString()));
			throw new TrafikBootRuntimeException(String.format("HttpStatusCodeException caught when trying to make rest call [requestUri=%s],[exception=%s]",requestURI,e.toString()));
		}catch (RestClientException e) {
			LOG.error(String.format("RestClientException caught when trying to make rest call [requestUri=%s],[exception=%s]",requestURI,e.toString()));
			throw new TrafikBootRuntimeException(String.format("RestClientException caught when trying to make rest call [requestUri=%s],[exception=%s]",requestURI,e.toString()));
		}
	}
}

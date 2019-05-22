package com.challenge.trafikboot.service;

import com.challenge.trafikboot.component.JsonResponseParser;
import com.challenge.trafikboot.config.ConfigProperties;
import com.challenge.trafikboot.rest.model.response.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : Bhakiyaraj Kalimuthu
 * @date : 2019-05-17
 */
@Service
public class TrafikServiceImpl implements TrafikService{

	private static final Logger LOG = LoggerFactory.getLogger(TrafikServiceImpl.class);
	private TrafikServiceRestApi trafikServiceRestApi;
	private TrafikServiceRequestURIBuilder trafikServiceRequestURIBuilder;
	private JsonResponseParser jsonResponseParser;
	private ConfigProperties config;

	@Autowired
	public TrafikServiceImpl(TrafikServiceRestApi trafikServiceRestApi, TrafikServiceRequestURIBuilder trafikServiceRequestURIBuilder, JsonResponseParser jsonResponseParser, ConfigProperties config) {
		this.trafikServiceRestApi = trafikServiceRestApi;
		this.trafikServiceRequestURIBuilder = trafikServiceRequestURIBuilder;
		this.jsonResponseParser = jsonResponseParser;
		this.config = config;
	}

	@Override
	public void start() {
		makeRestCalls();
	}

	/**
	 * makeRestCalls method makes all the 3 different rest calls to get the expected data
	 * It will internally build the url for all the request
	 */

	private void makeRestCalls(){
		ApiResponse lineResponse = trafikServiceRestApi.makeRequest(buildRequest(config.getBaseUrl(), TrafikModelType.LINE,config.getKey()));
		ApiResponse journeyPatternResponse = trafikServiceRestApi.makeRequest(buildRequest(config.getBaseUrl(), TrafikModelType.JOURNEY_PATTERN_POINT_ONLINE,config.getKey()));
		ApiResponse stopPointResponse = trafikServiceRestApi.makeRequest(buildRequest(config.getBaseUrl(), TrafikModelType.STOP_POINT,config.getKey()));
		List<ApiResponse> responseList = new LinkedList<>();
		responseList.add(lineResponse);
		responseList.add(journeyPatternResponse);
		responseList.add(stopPointResponse);
		parseJson(responseList);
	}

	/**
	 * Access modifier was changed from private to default to enhance
	 * testability
	 */

	UriComponents buildRequest(String baseUrl, TrafikModelType trafikModelType, String key){
		return trafikServiceRequestURIBuilder.buildUri(baseUrl,trafikModelType,key);
	}

	private void parseJson(List<ApiResponse> responseList){
		jsonResponseParser.parseJson(responseList);
	}
}

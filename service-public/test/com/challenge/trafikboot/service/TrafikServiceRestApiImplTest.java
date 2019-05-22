package com.challenge.trafikboot.service;

import com.challenge.trafikboot.rest.model.response.ApiResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author : Bhakiyaraj Kalimuthu
 * @date : 2019-05-20
 */
public class TrafikServiceRestApiImplTest {

	@InjectMocks
	TrafikServiceRestApiImpl trafikServiceRestApi;

	@Mock
	RestTemplate restTemplate;
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		trafikServiceRestApi = new TrafikServiceRestApiImpl(restTemplate);
	}

	@Test
	public void name() {
		ApiResponse apiResponse = mock(ApiResponse.class);
		apiResponse.setMessage("Test mock");
		when(restTemplate.getForEntity("https://api.sl.se/api2/LineData.json", TrafikServiceRestApiImpl.class))
				.thenReturn(new ResponseEntity(apiResponse, HttpStatus.OK));
		ApiResponse res = trafikServiceRestApi.makeRequest(mockBuilder());
		Assert.assertEquals(apiResponse.getMessage(), res.getMessage());
	}


	private UriComponents mockBuilder() {
		UriComponents lineUri = UriComponentsBuilder.fromHttpUrl("https://api.sl.se/api2/LineData.json")
				.queryParam("model", TrafikModelType.LINE.getModel())
				.queryParam("key", "5da196d47f8f4e5facdb68d2e25b9eae")
				.queryParam("DefaultTransportModeCode", "BUS")
				.build();
		return lineUri;
	}
}

package com.challenge.trafikboot.service;

import com.challenge.trafikboot.component.JsonResponseParser;
import com.challenge.trafikboot.config.ConfigProperties;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author : Bhakiyaraj Kalimuthu
 * @date : 2019-05-20
 */
public class TrafikServiceImplTest {

	@InjectMocks
	TrafikServiceImpl trafikService ;

	@Mock
	TrafikServiceRestApi trafikServiceRestApi;

	@Mock
	ConfigProperties config;

	@Mock
	TrafikServiceRequestURIBuilder trafikServiceRequestURIBuilder;

	@Mock
	JsonResponseParser jsonResponseParser;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		trafikService = new TrafikServiceImpl(trafikServiceRestApi,trafikServiceRequestURIBuilder,jsonResponseParser,config);
	}

	@Test
	public void buildLineRequestTest() {
		mockBuilder();
		UriComponents expected1 = trafikService.buildRequest("https://api.sl.se/api2/LineData.json",TrafikModelType.LINE,"5da196d47f8f4e5facdb68d2e25b9eae");
		Assert.assertEquals("https://api.sl.se/api2/LineData.json?model=line&key=5da196d47f8f4e5facdb68d2e25b9eae&DefaultTransportModeCode=BUS",expected1.toUriString());

	}

	@Test
	public void buildJourneyPointRequestTest() {
		mockBuilder();
		UriComponents expected2 = trafikService.buildRequest("https://api.sl.se/api2/LineData.json",TrafikModelType.JOURNEY_PATTERN_POINT_ONLINE,"5da196d47f8f4e5facdb68d2e25b9eae");
		Assert.assertEquals("https://api.sl.se/api2/LineData.json?model=JourneyPatternPointOnline&key=5da196d47f8f4e5facdb68d2e25b9eae",expected2.toUriString());

	}

	@Test
	public void buildStopPointRequestTest() {
		mockBuilder();
		UriComponents expected3 = trafikService.buildRequest("https://api.sl.se/api2/LineData.json",TrafikModelType.STOP_POINT,"5da196d47f8f4e5facdb68d2e25b9eae");
		Assert.assertEquals("https://api.sl.se/api2/LineData.json?model=StopPoint&key=5da196d47f8f4e5facdb68d2e25b9eae",expected3.toUriString());

	}

	private void mockBuilder(){
		UriComponents lineUri = UriComponentsBuilder.fromHttpUrl("https://api.sl.se/api2/LineData.json")
				.queryParam("model",TrafikModelType.LINE.getModel())
				.queryParam("key","5da196d47f8f4e5facdb68d2e25b9eae")
				.queryParam("DefaultTransportModeCode","BUS")
				.build();
		UriComponents journeyPointUri = UriComponentsBuilder.fromHttpUrl("https://api.sl.se/api2/LineData.json")
				.queryParam("model",TrafikModelType.JOURNEY_PATTERN_POINT_ONLINE.getModel())
				.queryParam("key","5da196d47f8f4e5facdb68d2e25b9eae")
				.build();
		UriComponents stopPointUri = UriComponentsBuilder.fromHttpUrl("https://api.sl.se/api2/LineData.json")
				.queryParam("model",TrafikModelType.STOP_POINT.getModel())
				.queryParam("key","5da196d47f8f4e5facdb68d2e25b9eae")
				.build();
		when(trafikServiceRequestURIBuilder.buildUri("https://api.sl.se/api2/LineData.json",TrafikModelType.LINE,"5da196d47f8f4e5facdb68d2e25b9eae"))
				.thenReturn(lineUri);
		when(trafikServiceRequestURIBuilder.buildUri("https://api.sl.se/api2/LineData.json",TrafikModelType.JOURNEY_PATTERN_POINT_ONLINE,"5da196d47f8f4e5facdb68d2e25b9eae"))
				.thenReturn(journeyPointUri);
		when(trafikServiceRequestURIBuilder.buildUri("https://api.sl.se/api2/LineData.json",TrafikModelType.STOP_POINT,"5da196d47f8f4e5facdb68d2e25b9eae"))
				.thenReturn(stopPointUri);

	}


}

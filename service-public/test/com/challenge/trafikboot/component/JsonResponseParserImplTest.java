package com.challenge.trafikboot.component;

import com.challenge.trafikboot.exception.TrafikBootRuntimeException;
import com.challenge.trafikboot.rest.model.response.ApiResponse;
import com.challenge.trafikboot.rest.model.response.Result;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @author : Bhakiyaraj Kalimuthu
 * @date : 2019-05-20
 */
public class JsonResponseParserImplTest {

	@InjectMocks
	JsonResponseParserImpl jsonResponseParser;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		jsonResponseParser = mock(JsonResponseParserImpl.class);
	}

	@Test
	public void parseBusLineTest() {
		List list = new ArrayList();

		list.add(ApiResponse.class);
		list.add(ApiResponse.class);
		list.add(ApiResponse.class);
		doNothing().when(jsonResponseParser).parseBusLine(list);
		jsonResponseParser.parseBusLine(list);
		verify(jsonResponseParser, times(1)).parseBusLine(list);
	}

	@Test
	public void parseJourneyPointTest() {

		Result[] res = new Result[]{new Result(),new Result()};
		doNothing().when(jsonResponseParser).parseBusJourneyPoint(Collections.singletonList("test"), res,res);
		jsonResponseParser.parseBusJourneyPoint(Collections.singletonList("test"), res,res);
		verify(jsonResponseParser, times(1)).parseBusJourneyPoint(Collections.singletonList("test"), res,res);
	}

	@Test
	public void parseStopPointTest() {

		Result[] res = new Result[]{new Result(),new Result()};
		doNothing().when(jsonResponseParser).parseAndMapBusStop(Collections.singletonMap("1",Collections.singletonList("test")), res);
		jsonResponseParser.parseAndMapBusStop(Collections.singletonMap("1",Collections.singletonList("test")), res);
		verify(jsonResponseParser, times(1)).parseAndMapBusStop(Collections.singletonMap("1",Collections.singletonList("test")), res);
	}

	@Test(expected = TrafikBootRuntimeException.class)
	public void parseBusLineExceptionTest() {
		List list = new ArrayList();

		list.add(ApiResponse.class);
		list.add(ApiResponse.class);
		list.add(ApiResponse.class);
		doThrow(TrafikBootRuntimeException.class).when(jsonResponseParser).parseBusLine(isNull(null));
		jsonResponseParser.parseBusLine(null);
	}

	@Test(expected = TrafikBootRuntimeException.class)
	public void parseJourneyPointExceptionTest() {

		doThrow(TrafikBootRuntimeException.class).when(jsonResponseParser).parseBusJourneyPoint(null, null,null);
		jsonResponseParser.parseBusJourneyPoint(null, null,null);
	}

	@Test(expected = TrafikBootRuntimeException.class)
	public void parseStopPointExceptionTest() {

		doThrow(TrafikBootRuntimeException.class).when(jsonResponseParser).parseAndMapBusStop(Collections.singletonMap("1",Collections.singletonList("test")), null);
		jsonResponseParser.parseAndMapBusStop(Collections.singletonMap("1",Collections.singletonList("test")), null);
	}

}

package com.challenge.trafikboot.util;

import com.challenge.trafikboot.component.JsonResponseParser;
import com.challenge.trafikboot.component.JsonResponseParserImpl;
import com.challenge.trafikboot.rest.model.response.ApiResponse;
import com.challenge.trafikboot.service.TrafikModelType;
import com.challenge.trafikboot.service.TrafikServiceImpl;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

/**
 * @author : Bhakiyaraj Kalimuthu
 * @date : 2019-05-18
 */
public class JsonResponseParserTest {
	@InjectMocks
	JsonResponseParserImpl jsonResponseParser;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		jsonResponseParser = mock(JsonResponseParserImpl.class);
	}

//	@Test
	public void parserTest() throws FileNotFoundException {
		List list = new ArrayList();
		list.add(buildApiResponse(TrafikModelType.LINE));
		list.add(buildApiResponse(TrafikModelType.JOURNEY_PATTERN_POINT_ONLINE));
		list.add(buildApiResponse(TrafikModelType.STOP_POINT));
		JsonResponseParserImpl jsonResponseParserImpl = new JsonResponseParserImpl();
		jsonResponseParserImpl.parseJson(list);
	}


	private ApiResponse buildApiResponse(TrafikModelType modelType) throws FileNotFoundException {
		Gson gson = new Gson();
		File file = null;
		if(modelType == TrafikModelType.LINE){
			file = new File("/Users/bhakal/Documents/Spring/trafik/Line1.json");
		}else if(modelType == TrafikModelType.JOURNEY_PATTERN_POINT_ONLINE){
			file = new File("/Users/bhakal/Documents/Spring/trafik/JourneyPatternPointOnline1.json");
		}else if(modelType == TrafikModelType.STOP_POINT){
			file = new File("/Users/bhakal/Documents/Spring/trafik/stopPoint1.json");
		}
		JsonReader reader = new JsonReader(new FileReader(file));
		reader.setLenient(true);
		return gson.fromJson(reader, ApiResponse.class);
	}

}

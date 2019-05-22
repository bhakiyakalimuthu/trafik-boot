package com.challenge.trafikboot.component;

import com.challenge.trafikboot.exception.TrafikBootRuntimeException;
import com.challenge.trafikboot.rest.model.response.ApiResponse;
import com.challenge.trafikboot.rest.model.response.Result;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : Bhakiyaraj Kalimuthu
 * @date : 2019-05-18
 */
@SuppressWarnings("Duplicates")
@Component
public class JsonResponseParserImpl implements JsonResponseParser{
	private static final Logger LOG = LoggerFactory.getLogger(JsonResponseParserImpl.class);


	@Override
	public void parseJson(List<ApiResponse> responseList ) {
		if(!CollectionUtils.isEmpty(responseList)) {
			if (responseList.size() == 3) {
				Validate.notNull(responseList.get(0), "ApiResponse is null");
				Validate.notNull(responseList.get(1), "ApiResponse is null");
				Validate.notNull(responseList.get(2), "ApiResponse is null");
				parseBusLine(responseList);
			}else {
				LOG.error("One of the value in ApiResponse List is empty.");
				throw new TrafikBootRuntimeException("One of the value in ApiResponse List is empty.");
			}
		} else {
			LOG.error("ApiResponse List is either empty or null.");
			throw new TrafikBootRuntimeException("ApiResponse List is either empty or null.");
		}
	}

	/**
	 * Access modifier was changed from private to default to enhance
	 * testability
	 */

	void parseBusLine(List<ApiResponse> responseList){

		List<String> list1 = Arrays.stream(responseList.get(0).getResponseData().getResult())
				.map(Result::getLineNumber)
				.collect(Collectors.toList());

		Result[] list2 = responseList.get(1).getResponseData().getResult();
		Result[] list3 = responseList.get(2).getResponseData().getResult();

		parseBusJourneyPoint(list1, list2, list3);

	}
	/**
	 * Access modifier was changed from private to default to enhance
	 * testability
	 */
	void parseBusJourneyPoint(List<String> list1, Result[] list2, Result[] list3){

		if(!CollectionUtils.isEmpty(list1) && !ObjectUtils.isEmpty(list2) && !ObjectUtils.isEmpty(list3)) {
			Map<String, List<String>> map = new HashMap();
			for (String line : list1) {
				for (Result journeyPoint : list2) {
					if (line.equals(journeyPoint.getLineNumber())) {
						if (map.containsKey(line)) {
							map.get(line).add(journeyPoint.getJourneyPatternPointNumber());
						} else {
							List jList = new ArrayList();
							jList.add(journeyPoint.getJourneyPatternPointNumber());
							map.put(line, jList);
						}
					}
				}
			}
			parseAndMapBusStop(map, list3);
		} else {
			LOG.error("ParseBusLine result is either empty or null.");
			throw new TrafikBootRuntimeException("ParseBusLine result is either empty or null.");
		}
	}
	/**
	 * Access modifier was changed from private to default to enhance
	 * testability
	 */
	void parseAndMapBusStop(Map<String,List<String>> map, Result[] results){
		Multimap<String, String> dataMultiMap = LinkedListMultimap.create();
		 if(!CollectionUtils.isEmpty(map.values()) && !ObjectUtils.isEmpty(results) ) {
			 map.entrySet()
					 .stream().sorted((left, right) ->
					 Integer.compare(right.getValue().size(), left.getValue().size()))
					 .limit(10)
					 .forEach(stops ->
							 stops.getValue().stream().forEach(stop ->
									 Arrays.stream(results)
											 .filter(result ->
													 stop.equals(result.getStopPointNumber()))
											 .map(result ->
													 result.getStopPointName())
											 .forEach(res -> {
											 			dataMultiMap.put(String.format("LineNumber:%s",stops.getKey()),String.format("%s-%s",stop,res));
//												 LOG.info("BusLine : " + stops.getKey() + " has busStop count of  : " + stops.getValue().size() + " - BusStopNumber : " + stop + " - Name : " + res);
													 })));
		 }else {
			 LOG.error("parseBusJourneyPoint result is either empty or null.");
			 throw new TrafikBootRuntimeException("parseBusJourneyPoint result is either empty or null.");
		 }
		formatAndPrintOutput(dataMultiMap);

	}


	private void formatAndPrintOutput(Multimap map){
		Map utilMap = map.asMap();
		LOG.info("========================================================================================\n");
		LOG.info(String.format("Top 10 bus lines have the most bus stops on their route.BUSLINE : %s"
				,utilMap.keySet().toString()));
		LOG.info("\n========================================================================================");
		Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();
		String json = gsonBuilder.toJson(utilMap);
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(json);
		String prettyJsonString = gsonBuilder.toJson(je);

		LOG.info(prettyJsonString);
	}

}

package com.challenge.trafikboot.service;

import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author : Bhakiyaraj Kalimuthu
 * @date : 2019-05-17
 */
@Service
public class TrafikServiceRequestURIBuilderImpl implements TrafikServiceRequestURIBuilder{

	/**
	 * Builder class to build the request uri based on the model type
	 */

	@Override
	public UriComponents buildUri(String baseUrl, TrafikModelType trafikModelType, String key) {
		if(trafikModelType == TrafikModelType.LINE){
			return UriComponentsBuilder.fromHttpUrl(baseUrl)
					.queryParam("model",trafikModelType.getModel())
					.queryParam("key",key)
					.queryParam("DefaultTransportModeCode","BUS")
					.build();
		}
		return UriComponentsBuilder.fromHttpUrl(baseUrl)
				.queryParam("model",trafikModelType.getModel())
				.queryParam("key",key)
				.build();
	}
}

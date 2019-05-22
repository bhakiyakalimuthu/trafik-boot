package com.challenge.trafikboot.component;

import com.challenge.trafikboot.rest.model.response.ApiResponse;

import java.util.List;

/**
 * @author : Bhakiyaraj Kalimuthu
 * @date : 2019-05-19
 */
public interface JsonResponseParser {
	void parseJson(List<ApiResponse> responseList);
}

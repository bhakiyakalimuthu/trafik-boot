package com.challenge.trafikboot.service;

import com.challenge.trafikboot.rest.model.response.ApiResponse;
import org.springframework.web.util.UriComponents;

/**
 * @author : Bhakiyaraj Kalimuthu
 * @date : 2019-05-17
 */
public interface TrafikServiceRestApi {
	ApiResponse makeRequest(UriComponents requestURI);
}

package com.challenge.trafikboot.service;

import org.springframework.web.util.UriComponents;

/**
 * @author : Bhakiyaraj Kalimuthu
 * @date : 2019-05-17
 */
public interface TrafikServiceRequestURIBuilder {

	UriComponents buildUri(String baseUrl, TrafikModelType trafikModelType,String key);

}

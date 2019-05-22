package com.challenge.trafikboot.service;

/**
 * @author : Bhakiyaraj Kalimuthu
 * @date : 2019-05-17
 */
public enum TrafikModelType {

	/**
	 *Different model types for Rest Request
	 */

	LINE("line"),
	STOP_POINT("StopPoint"),
	JOURNEY_PATTERN_POINT_ONLINE("JourneyPatternPointOnline");

	private final String model;

	TrafikModelType(String model) {
		this.model = model;
	}

	public String getModel(){
		return model;
	}
}

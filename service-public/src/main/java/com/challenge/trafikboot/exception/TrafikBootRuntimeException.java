package com.challenge.trafikboot.exception;

/**
 * @author : Bhakiyaraj Kalimuthu
 * @date : 2019-05-20
 */
public class TrafikBootRuntimeException extends RuntimeException {

	public TrafikBootRuntimeException(String message) {
		super(message);
	}

	public TrafikBootRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}
}

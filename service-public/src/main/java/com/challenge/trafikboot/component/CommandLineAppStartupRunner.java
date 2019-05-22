package com.challenge.trafikboot.component;

import com.challenge.trafikboot.service.TrafikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author : Bhakiyaraj Kalimuthu
 * @date : 2019-05-18
 */
@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

	private TrafikService trafikService;

	@Autowired
	public CommandLineAppStartupRunner(TrafikService trafikService) {
		this.trafikService = trafikService;
	}


	/**
	 * Run method will be called once the application started (spring beans are initialized)
	 * This will intern call the trafikservice
	 */

	@Override
	public void run(String... args) {
		trafikService.start();
	}
}

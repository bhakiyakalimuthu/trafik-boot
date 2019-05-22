package com.challenge.trafikboot.component;

import com.challenge.trafikboot.service.TrafikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;


/**
 * @author : Bhakiyaraj Kalimuthu
 * @date : 2019-05-19
 */
//@Component
public class TrafikBootAppStarter {

    private TrafikService trafikService;

    @Autowired
    public TrafikBootAppStarter(TrafikService trafikService) {
        this.trafikService = trafikService;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        trafikService.start();
    }

}

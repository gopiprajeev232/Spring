package com.spring.aroundadvice.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {
    public String getFortune() {
        boolean exceptionOccurs = true;

        if(exceptionOccurs == true) {
            throw new RuntimeException("Major accident! Road is closed.");
        }

        return "Expect heavy traffic this evening";
    }
}

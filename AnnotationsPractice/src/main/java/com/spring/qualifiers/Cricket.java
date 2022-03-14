package com.spring.qualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("cricket")
public class Cricket implements Sport {
    @Autowired
    @Qualifier("badWeather")
    private Weather weather;

    public Cricket() {
    }

    @Override
    public void playSport() {
        System.out.println("You are playing cricket right now.");
    }

    @Override
    public String checkWeatherConditions() {
        return weather.getWeatherInfo();
    }
}

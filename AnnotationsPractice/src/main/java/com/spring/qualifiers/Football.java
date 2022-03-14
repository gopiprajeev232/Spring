package com.spring.qualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Football implements Sport {
    @Autowired
    @Qualifier("goodWeather")
    private Weather weather;

    @Override
    public void playSport() {
        System.out.println("You are playing football right now.");
    }

    @Override
    public String checkWeatherConditions() {
        return weather.getWeatherInfo();
    }
}

package com.spring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Football implements Sport {
    private Weather weather;

    @Autowired
    public Football(Weather weather) {
        this.weather = weather;
    }

    @Override
    public void playSport() {
        System.out.println("You are playing football right now.");
    }

    @Override
    public String checkWeatherConditions() {
        return weather.getWeatherInfo();
    }
}

package com.spring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("cricket")
public class Cricket implements Sport {
    private Weather weather;

    public Cricket() {
    }

    @Autowired
    public void setWeather(Weather weather) {
        this.weather = weather;
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

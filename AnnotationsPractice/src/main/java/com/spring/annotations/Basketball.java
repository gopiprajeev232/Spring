package com.spring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("basketball")
public class Basketball implements Sport {
    private Weather weather;

    public Basketball() {
    }

    @Autowired
    public void someRandomMethod(Weather weather) {
        this.weather = weather;
    }

    @Override
    public void playSport() {
        System.out.println("You are playing basketball right now.");
    }

    @Override
    public String checkWeatherConditions() {
        return weather.getWeatherInfo();
    }
}
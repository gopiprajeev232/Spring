package com.spring.qualifiers;

import org.springframework.stereotype.Component;

@Component
public class BadWeather implements Weather {
    @Override
    public String getWeatherInfo() {
        return "The weather conditions are bad. Game can't be played.";
    }
}

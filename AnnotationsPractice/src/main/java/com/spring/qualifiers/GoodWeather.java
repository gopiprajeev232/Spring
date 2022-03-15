package com.spring.qualifiers;

import org.springframework.stereotype.Component;

@Component
public class GoodWeather implements Weather {
    @Override
    public String getWeatherInfo() {
        return "The weather conditions are good. Game can be played.";
    }
}

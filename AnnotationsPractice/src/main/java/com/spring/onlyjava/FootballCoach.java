package com.spring.onlyjava;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {
    @Override
    public void dailyWorkout() {
        System.out.println("Practice free kicks for 30 minutes.");
    }

    @Override
    public String fortuneToday() {
        return null;
    }
}

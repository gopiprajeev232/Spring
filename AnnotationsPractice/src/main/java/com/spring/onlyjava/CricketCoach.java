package com.spring.onlyjava;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public @Data
class CricketCoach implements Coach {
    private FortuneService fortuneService;

    @Value("${foo.email}")
    private String coachEmail;

    @Value("${foo.team}")
    private String coachTeam;

    public CricketCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public void dailyWorkout() {
        System.out.println("Practice batting and bowling for 30 minutes respectively.");
    }

    @Override
    public String fortuneToday() {
        return this.fortuneService.getFortune();
    }
}

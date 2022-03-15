package com.spring.basics;

public class FootballCoach implements Coach {
    private FortuneService fortuneService;

    public FootballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice free kicks for an hour.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}

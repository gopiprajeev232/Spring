package com.spring.basics;

public class BasketballCoach implements Coach {
    private FortuneService fortuneService;

    public BasketballCoach() {
        System.out.println("Inside no arg constructor.");
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("Inside setFortuneService method");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice 2 pointers and 3 pointers for 2 hours.";
    }

    @Override
    public String getDailyFortune() {
        return "Basketball coach: "+fortuneService.getFortune();
    }
}

package com.spring.basics;

public class CricketCoach implements Coach {
    private FortuneService fortuneService;

    public CricketCoach(FortuneService fortuneService)
    {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout()
    {
        return "Practice batting and bowling for an hour.";
    }

    @Override
    public String getDailyFortune() {
        return "Cricket coach: "+fortuneService.getFortune();
    }

    public void initMethod() {
        System.out.println("Inside init method of cricket coach");
    }

    public void destroyMethod() {
        System.out.println("Inside destroy method of cricket coach");
    }
}

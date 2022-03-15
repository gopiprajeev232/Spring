package com.spring.basics;

// Injecting literal values

public class HockeyCoach implements Coach {
    private String emailAddress;
    private String team;

    private FortuneService fortuneService;

    public HockeyCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public String getTeam() {
        return this.team;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice hockey for 45 minutes.";
    }

    @Override
    public String getDailyFortune() {
        return "Hockey coach says: "+fortuneService.getFortune();
    }
}

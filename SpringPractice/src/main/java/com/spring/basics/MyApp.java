package com.spring.basics;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // IOC
        Coach footballCoach = context.getBean("footballCoach", Coach.class);
        System.out.println(footballCoach.getDailyWorkout());

        System.out.println();

        // Constructor Dependency Injection
        Coach cricketCoach = context.getBean("cricketCoach", Coach.class);
        cricketCoach.getDailyWorkout();
        cricketCoach.getDailyFortune();

        System.out.println();

        // Setter Dependency Injection
        Coach basketballCoach = context.getBean("basketballCoach", Coach.class);
        System.out.println(basketballCoach.getDailyWorkout());
        System.out.println(basketballCoach.getDailyFortune());

        System.out.println();

        // Injecting literals from properties
        HockeyCoach hockeyCoach = context.getBean("hockeyCoach", HockeyCoach.class);
        System.out.println("Team is: "+hockeyCoach.getTeam()+" and email address is: "+hockeyCoach.getEmailAddress());
    }
}

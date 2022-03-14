package com.spring.onlyjava;

import com.spring.beans.Cricket;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CoachConfig.class);

        CricketCoach coach = context.getBean("cricketCoach", CricketCoach.class);

        coach.dailyWorkout();
        System.out.println(coach.fortuneToday());
        System.out.println(coach.getCoachEmail());
        System.out.println(coach.getCoachTeam());
    }
}

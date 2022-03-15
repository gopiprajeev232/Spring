package com.spring.qualifiers;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QualifiersDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("qualifiers-applicationContext.xml");

        Sport cricket = context.getBean("cricket", Sport.class);
        cricket.playSport();

        Sport football = context.getBean("football", Sport.class);
        football.playSport();
        System.out.println(football.checkWeatherConditions());
    }
}

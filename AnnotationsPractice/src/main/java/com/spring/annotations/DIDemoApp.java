package com.spring.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DIDemoApp {
    public static void main(String... args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Sport basketball = context.getBean("basketball", Sport.class);
        basketball.playSport();
        System.out.println(basketball.checkWeatherConditions());
    }
}

package com.spring.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Sport cricket = context.getBean("cricket", Sport.class);
        cricket.playSport();

        Sport football = context.getBean("football", Sport.class);
        football.playSport();
    }
}

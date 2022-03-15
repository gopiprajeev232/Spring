package com.spring.basics;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {
    public static void main(String... args) {
        ClassPathXmlApplicationContext xmlApplicationContext =
                new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

        Coach theCoach = xmlApplicationContext.getBean("cricketCoach", Coach.class);

        System.out.println(theCoach.getDailyWorkout());

        xmlApplicationContext.close();
    }
}

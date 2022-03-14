package com.spring.basics;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String... args) {
        ClassPathXmlApplicationContext xmlApplicationContext =
                new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        Coach theCoach = xmlApplicationContext.getBean("cricketCoach", Coach.class);
        Coach cricketCoach = xmlApplicationContext.getBean("cricketCoach", Coach.class);

        boolean result = (theCoach == cricketCoach);
        System.out.println(result+" Memory location: "+theCoach+" "+cricketCoach);
    }
}

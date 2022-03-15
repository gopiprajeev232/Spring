package com.spring.beans;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeansWithAnnotationDemo {
    public static void main(String... args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-applicationContext.xml");

        Sport sport = context.getBean("cricket", Sport.class);
        Sport cricket = context.getBean("cricket", Sport.class);

        System.out.println("Pointing to the same object: "+(sport == cricket));

        context.close();
    }
}

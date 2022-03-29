package com.spring.aroundadvice;

import com.spring.aroundadvice.dao.AccountDAO;
import com.spring.aroundadvice.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("Calling getFortune() method");
        String data = trafficFortuneService.getFortune();

        System.out.println(data);
    }
}

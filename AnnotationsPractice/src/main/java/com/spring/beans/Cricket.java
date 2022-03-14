package com.spring.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Cricket implements Sport {
    @Override
    public void playSport() {
        System.out.println("Playing cricket.");
    }

    @PostConstruct
    public void initMethod() {
        System.out.println("Inside init method");
    }

    @PreDestroy
    public void destroyMethod() {
        System.out.println("Inside destroy method.");
    }
}

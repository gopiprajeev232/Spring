package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {
    @Before("execution(* com.spring.aop.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("Before advice executing on method");
    }
}

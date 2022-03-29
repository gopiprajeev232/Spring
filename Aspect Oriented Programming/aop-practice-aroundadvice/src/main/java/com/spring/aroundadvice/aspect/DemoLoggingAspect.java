package com.spring.aroundadvice.aspect;

import com.spring.aroundadvice.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class DemoLoggingAspect {
    @Around("execution(* com.spring.aroundadvice.service.*.get*(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n===> Executing @Around on method: "+method);

        Object result = null;
        long begin = System.currentTimeMillis();
        try {
            result = proceedingJoinPoint.proceed();
        }

        catch(Exception e) {
            System.out.println("\n===> Exception at @Around method... "+e.getMessage());
            result = "Accident occured but don't worry, help is on the way!";
        }

        long end = System.currentTimeMillis();

        long duration = end - begin;

        System.out.println("Time taken to execute: "+duration/1000+" seconds");

        return result;
    }
}

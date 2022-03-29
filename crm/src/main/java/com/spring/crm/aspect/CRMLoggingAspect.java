package com.spring.crm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.spring.crm.controller.*.*(..))")
    private void forControllerPackage() { }

    @Pointcut("execution(* com.spring.crm.service.*.*(..))")
    private void forServicePackage() { }

    @Pointcut("execution(* com.spring.crm.dao.*.*(..))")
    private void forDaoPackage() { }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() { }

    @Before("forAppFlow()")
    public void beforeJoinPoint(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("==> in @Before: calling method: "+method);

        Object[] args = joinPoint.getArgs();

        for(Object arg : args) {
            logger.info("==> argument: "+arg);
        }
    }
}

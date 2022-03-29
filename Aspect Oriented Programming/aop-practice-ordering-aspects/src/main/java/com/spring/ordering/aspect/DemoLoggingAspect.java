package com.spring.ordering.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class DemoLoggingAspect {
    @Pointcut("execution(* com.spring.ordering.dao.*.*(..))")
    public void pointcutForDAO() { }

    @Before("com.spring.ordering.aspect.DemoLoggingAspect.pointcutForDAO()")
    private void beforeAddAccountService() {
        System.out.println("\n==> Executing @Before advice method...");
    }
}

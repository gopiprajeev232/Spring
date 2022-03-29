package com.spring.joinpoint.aspect;

import com.spring.joinpoint.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class DemoLoggingAspect {
    @Pointcut("execution(* com.spring.joinpoint.dao.*.*(..))")
    public void pointcutForDAO() { }

    @Before("com.spring.joinpoint.aspect.DemoLoggingAspect.pointcutForDAO()")
    private void beforeAddAccountService(JoinPoint joinPoint)
    {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("\n==> Executing @Before advice method...");

        System.out.println("Method signature: "+methodSignature);

        Object[] args = joinPoint.getArgs();

        for(Object arg : args) {
            System.out.println("Argument: "+arg);

            if(arg instanceof Account) {
                Account acc = (Account) arg;
                System.out.println("Acc name: "+((Account) arg).getName());
                System.out.println("Acc level: "+ ((Account) arg).getLevel());
            }
        }
    }
}

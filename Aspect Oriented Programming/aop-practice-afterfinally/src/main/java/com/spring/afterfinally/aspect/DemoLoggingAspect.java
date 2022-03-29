package com.spring.afterfinally.aspect;

import com.spring.afterfinally.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class DemoLoggingAspect {
    @Before("execution(* com.spring.afterfinally.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n===> Before advice executing on method");
    }

    @After("execution(* com.spring.afterfinally.dao.*.*(..))")
    public void afterFindAccountsAdvice(JoinPoint joinPoint) {
        System.out.println("Executing @After advice on method: "+joinPoint.getSignature().toShortString());
    }

    @AfterReturning(pointcut = "execution(* com.spring.afterfinally.dao.*.find*(..))", returning = "accounts")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> accounts) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n===> Executing AfterReturn on method: "+method);

        System.out.println("\n===> Result is: "+accounts);
    }

    @AfterThrowing(pointcut = "execution(* com.spring.afterfinally.dao.*.find*(..))", throwing = "exc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n===> Executing @AfterThrowing on method: "+method);
        System.out.println("\n===> Exception is: "+exc.getLocalizedMessage());
    }
}

package com.spring.afterthrowing.aspect;

import com.spring.afterthrowing.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class DemoLoggingAspect {
    @Before("execution(* com.spring.afterthrowing.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n===> Before advice executing on method");
    }

    @AfterReturning(pointcut = "execution(* com.spring.afterthrowing.dao.*.find*(..))", returning = "accounts")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> accounts) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n===> Executing AfterReturn on method: "+method);

        System.out.println("\n===> Result is: "+accounts);
    }

    @AfterThrowing(pointcut = "execution(* com.spring.afterthrowing.dao.*.find*(..))", throwing = "exc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n===> Executing @AfterThrowing on method: "+method);
        System.out.println("\n===> Exception is: "+exc.getLocalizedMessage());
    }
}

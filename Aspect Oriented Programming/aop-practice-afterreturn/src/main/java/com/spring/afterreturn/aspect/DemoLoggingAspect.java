package com.spring.afterreturn.aspect;

import com.spring.afterreturn.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Aspect
@Component
public class DemoLoggingAspect {
    @Before("execution(* com.spring.afterreturn.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n===> Before advice executing on method");
    }

    @AfterReturning(pointcut = "execution(* com.spring.afterreturn.dao.*.find*(..))", returning = "accounts")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> accounts) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n===> Executing AfterReturn on method: "+method);

        System.out.println("\n===> Result is: "+accounts);

        convertAccountNamesToLowerCase(accounts);
    }

    private void convertAccountNamesToLowerCase(List<Account> accounts) {
        for(Account acc : accounts) {
            acc.setName(acc.getName().toLowerCase());
        }
    }
}

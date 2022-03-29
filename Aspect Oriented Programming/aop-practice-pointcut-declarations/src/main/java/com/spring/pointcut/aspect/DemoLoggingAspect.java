package com.spring.pointcut.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {
    @Pointcut("execution(* com.spring.pointcut.dao.*.*(..))")
    private void daoPointcut() { }

    @Pointcut("execution(* com.spring.pointcut.dao.*.get*(..))")
    private void getterPointcut() { }

    @Pointcut("execution(* com.spring.pointcut.dao.*.set*(..))")
    private void setterPointcut() { }

    @Pointcut("daoPointcut() && !(getterPointcut() || setterPointcut())")
    private void forDaoPackageNoGetterSetterPointcut() { }

    @Before("forDaoPackageNoGetterSetterPointcut()")
    public void beforeAddAccountAdvice() {
        System.out.println("\nExecuting @Before advice on method");
    }
}

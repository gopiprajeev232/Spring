package com.spring.ordering.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class APIAnalyticsAspect {
    @Before("com.spring.ordering.aspect.DemoLoggingAspect.pointcutForDAO()")
    private void performAPIAnalytics() {
        System.out.println("\n==> Performing API analytics...");
    }
}

package com.spring.ordering.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class CloudLoggingAspect {
    @Before("com.spring.ordering.aspect.DemoLoggingAspect.pointcutForDAO()")
    private void logToCloudAsync() {
        System.out.println("\n==> Logging to cloud asynchronously....");
    }
}

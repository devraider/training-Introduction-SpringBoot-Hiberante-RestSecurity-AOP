package com.pau.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Aspect
@Order(1)
public class MyDemoAnalyticsAspect {

    @Before("com.pau.aop.aspect.AOPExpressions.forPointcutDeclaration()")
    public void performApiAnalytics(JoinPoint joinPoint) {

        System.out.println("--------Before-----------");
        System.out.println("Aspect" + "performApiAnalytics");
        System.out.println("Executed method " + joinPoint.getSignature().toString());
        System.out.println("Args " + Arrays.toString(joinPoint.getArgs()));
        List<String> s = new ArrayList<>();
        System.out.println("--------Before-----------");
    }
}

package com.pau.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Order(2)
public class MyDemoCloudAspect {

    @Before("com.pau.aop.aspect.AOPExpressions.forPointcutDeclaration()")
    public void performCloudLinking(JoinPoint joinPoint) {

        System.out.println("--------Before-----------");
        System.out.println("Aspect" + "performCloudLinking");
        System.out.println("Executed method " + joinPoint.getSignature().toString());
        System.out.println("Args " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("--------Before-----------");
    }
}

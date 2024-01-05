package com.pau.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(1)
public class MyDemoLoginAspect {
    //                 optional
//                         |
//    @Before("execution(public void updateAccount())")

    @Before("com.pau.aop.aspect.AOPExpressions.forPointcutDeclaration()")
    public void performAccountAdvice(JoinPoint joinPoint) {

        System.out.println("--------Before-----------");
        System.out.println("Aspect" + "beforeAccountAdvice");
        System.out.println("Executed method " + joinPoint.getSignature().toString());
        System.out.println("Args " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("--------Before-----------");
    }



}

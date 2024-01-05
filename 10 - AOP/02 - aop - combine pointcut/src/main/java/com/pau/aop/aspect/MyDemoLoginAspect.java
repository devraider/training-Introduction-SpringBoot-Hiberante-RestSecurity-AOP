package com.pau.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class MyDemoLoginAspect {
    //                 optional
//                         |
//    @Before("execution(public void updateAccount())")
    @Pointcut("execution(* com.pau.aop.dao.*.*(..))")
    private void forPointcutDeclaration() {}

    @Pointcut("execution(* com.pau.aop.dao.*.set*(..))")
    private void setter() {}

    @Pointcut("execution(* com.pau.aop.dao.*.get*(..))")
    private void getter() {}

    @Before("forPointcutDeclaration() && !(setter()|| getter())")
    public void beforeAccountAdvice(JoinPoint joinPoint) {

        System.out.println("--------Before-----------");
        System.out.println("Aspect" + "beforeAccountAdvice");
        System.out.println("Executed method " + joinPoint.getSignature().toString());
        System.out.println("Args " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("--------Before-----------");
    }


    @Before("forPointcutDeclaration()")
    public void performApiAnalytics(JoinPoint joinPoint) {

        System.out.println("--------Before-----------");
        System.out.println("Aspect" + "performApiAnalytics");
        System.out.println("Executed method " + joinPoint.getSignature().toString());
        System.out.println("Args " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("--------Before-----------");
    }
}

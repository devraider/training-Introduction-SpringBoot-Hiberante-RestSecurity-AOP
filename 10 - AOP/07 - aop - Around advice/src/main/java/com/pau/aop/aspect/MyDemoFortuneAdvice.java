package com.pau.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class MyDemoFortuneAdvice {

    @Around("execution(* com.pau.aop.service.TrafficFortuneServiceImpl.getFortune(..))")
    public Object demoAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("@Around Running: " + proceedingJoinPoint.getTarget());

        long start = System.currentTimeMillis();

        try {
            Object r=  proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            System.out.println("@Around Obj is: " + r +"\n@Around Run: " + (end-start)/1000 + " sec");
            return r;
        } catch (Exception e) {
            System.out.println("@Around caught exception: " + e);
            throw e;
        }
    }
}

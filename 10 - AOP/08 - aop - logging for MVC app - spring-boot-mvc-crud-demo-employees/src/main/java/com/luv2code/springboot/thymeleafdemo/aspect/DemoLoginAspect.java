package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Component
@Aspect
public class DemoLoginAspect {

    //setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // pointcut declarations
    @Pointcut("execution(*  com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    public void forControllerPackage() {}
    @Pointcut("execution(*  com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    public void forServicePackage() {}

    @Pointcut("execution(*  com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
    public void forAppFlow() {}

    //add before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        // display method
        myLogger.info("@Before(forAppFlow) Method->"+joinPoint.getSignature().toShortString());
        // display argument
        myLogger.info("@Before(forAppFlow) Argument->"+ Arrays.toString(joinPoint.getArgs()));
    }

    //add after returning

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {

        myLogger.info("@AfterReturning(forAppFlow) Method->"+joinPoint.getSignature().toShortString());

        myLogger.info("@AfterReturning(forAppFlow) Return data->"+ result.toString());

    }
}

package com.pau.aop.aspect;

import com.pau.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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


    @AfterReturning(pointcut="com.pau.aop.aspect.AOPExpressions.findAccountsAdvice()", returning = "accounts")
    public void performAfterAccountAdvice(JoinPoint joinPoint, List<Account> accounts) {

        System.out.println("--------After-----------");
        System.out.println("Aspect" + "performAfterAccountAdvice");
        System.out.println("Executed method " + joinPoint.toShortString());
        System.out.println("Args " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Accounts"+accounts);
        accounts.forEach(account -> account.setName("ddd"));
        System.out.println("--------After-----------");
    }

    @AfterThrowing(pointcut="com.pau.aop.aspect.AOPExpressions.findAccountsAdvice()", throwing = "exe")
    public void performAfterThrowingAccountAdvice(JoinPoint joinPoint, Throwable exe) {

        System.out.println("--------AfterExecption-----------");
        System.out.println("Aspect" + "performAfterThrowingAccountAdvice");
        System.out.println("Executed method " + joinPoint.toShortString());
        System.out.println("Args " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Exception"+exe.printStackTrace(););
        System.out.println("--------AfterExecption-----------");
    }
}

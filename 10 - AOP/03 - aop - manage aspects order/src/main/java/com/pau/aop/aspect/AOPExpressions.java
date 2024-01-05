package com.pau.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // it's optional, required only if you have Advices inside
public class AOPExpressions {
    @Pointcut("execution(* com.pau.aop.dao.*.*(..))")
    public void forPointcutDeclaration() {}

    @Pointcut("execution(* com.pau.aop.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("execution(* com.pau.aop.dao.*.get*(..))")
    public void getter() {}
}

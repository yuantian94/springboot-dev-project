package com.project.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is where we add all our related advices for logging

    // let's start with an @Before advice
    @Pointcut("execution(* com.project.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}
    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n======>>> Executing @Before advice on addAccount()");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics(){
        System.out.println("\n======>>> Performing API analytics");
    }
}

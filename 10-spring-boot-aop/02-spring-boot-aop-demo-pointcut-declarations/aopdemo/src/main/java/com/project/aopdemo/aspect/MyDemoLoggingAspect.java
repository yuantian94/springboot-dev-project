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

    // create pointcut for getter methods
    @Pointcut("execution(* com.project.aopdemo.dao.*.get*(..))")
    private void getter(){}

    @Pointcut("execution(* com.project.aopdemo.dao.*.set*(..))")
    private void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter(){}


    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n======>>> Executing @Before advice on addAccount()");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n======>>> Performing API analytics");
    }
}

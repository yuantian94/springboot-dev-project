package com.project.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is where we add all our related advices for logging

    // let's start with an @Before advice

    //@Before("execution(public void addAccount())")
    //@Before("execution(public void updateAccount())")
    //@Before("execution(public void com.project.aopdemo.dao.AccountDAO.addAccount())")
    //@Before("execution(public void add*())")                // using wildcard
    //@Before("execution(void add*(com.project.aopdemo.Account))")
    //@Before("execution(void add*(com.project.aopdemo.Account,..))")
    //@Before("execution(* add*(..))")
    @Before("execution(* com.project.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n======>>> Executing @Before advice on addAccount()");
    }
}

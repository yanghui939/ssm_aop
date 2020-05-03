package com.yh.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class Log {

    
    public void before(){
        System.out.println("before");
    }
    public void afterReturning(){
        System.out.println("afterReturning");
    }
    public void afterThrowing(){
        System.out.println("afterThrowing");
    }
    public void after(){
        System.out.println("after");
    }
    public Object around(ProceedingJoinPoint joinPoint){
        Object rtValue = null;
        try {
            Object[] args = joinPoint.getArgs();
            System.out.println("before");
            rtValue = joinPoint.proceed(args);
            System.out.println("afterReturning");
            return rtValue;
        } catch (Throwable e) {
            System.out.println("afterThrowing");
            throw new RuntimeException(e);
        }finally {
            System.out.println("after");
        }
    }
}

package com.lucky.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyAdvice {
    @Pointcut("execution(void com.lucky.dao.BookDao.update())")
    private void pt(){}


    @Pointcut("execution(void com.lucky.dao.BookDao.save())")
    private void pt2(){}

//    @Before("pt()")
    public void method(){
        // 打印当前时间
        System.out.println(System.currentTimeMillis());
    }

    @Around("pt2()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            proceedingJoinPoint.proceed();
        }
        long end = System.currentTimeMillis();
        System.out.println("Total spend" + (end -start) + "ms");
    }

}

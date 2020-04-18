package com.owen.iframe.poc.spring.aop;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Slf4j
@Aspect
@Component
public class MyAspect {
    @Pointcut("execution(* com.owen.iframe.poc.spring.aop.*Service*.do*(..))")
    public void pointCut() {
    }

    @Pointcut("execution(* com.owen.iframe.poc.spring.aop.*Service*.throw*(..))")
    public void exceptionPointCut() {
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        log.info("------------before business--------------");
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint){
        log.info("------------after business--------------");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp){
        try {
            log.info("------------around business start--------------");
            Object[] args = pjp.getArgs();
            Object rs = pjp.proceed();
            log.info("------------around business end--------------");
            return  rs;
        } catch (Throwable throwable) {
            throw new RuntimeException( throwable);
        }
    }

    @AfterReturning(pointcut = "pointCut()", returning = "returnVal")
    public void afterReturning(JoinPoint joinPoint, Object returnVal) {
        log.info("------------afterReturning --------------, return result is {}" ,returnVal);
    }

    @AfterThrowing(pointcut = "exceptionPointCut()", throwing = "error")
    public void afterThrowing(JoinPoint jp, Throwable error) {
        log.info("------------afterThrowing --------------, error msg: {}" ,error.getMessage());
    }
}
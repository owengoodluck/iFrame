package com.owen.iframe.poc.aop;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Slf4j
@Aspect
@Component
public class MyAspect {
    @Pointcut("execution(* com.owen.iframe.poc.aop.*Service*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before1(){
        log.info("before...");
    }

    @After("pointCut()")
    public void after(){
        log.info("after...");
    }

    @Around("pointCut()")
    public void around(){
        log.info("around...");
    }

}

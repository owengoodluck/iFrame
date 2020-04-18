package com.owen.iframe.poc.fundamental.dynamicproxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Slf4j
public class MyInvocationHandler implements InvocationHandler {
    private Object target;
    public MyInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("--------Java dynamic proxy enhance: Before target method----------");
        Object result = method.invoke(target, args);
        log.info("--------Java dynamic proxy enhance: After target method----------");
        return result;
    }
}

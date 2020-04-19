package com.owen.iframe.poc.fundamental.dynamicproxy;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class CglibProxy implements MethodInterceptor {
    // 根据一个类型产生代理类，此方法不要求一定放在MethodInterceptor中
    public Object CreatProxyedObj(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable
    {
        log.info("--------Cglib enhance: Before target method----------");
        Object result = arg3.invokeSuper(arg0, arg2);
        log.info("--------Cglib enhance: Before target method----------");
        return  result;
    }

    public static void main(String[] args) {
        CarBMW myCar = new CarBMW();
        CglibProxy factory = new CglibProxy();
        myCar = (CarBMW)factory.CreatProxyedObj(myCar.getClass());
        myCar.run();
    }
}

package com.owen.iframe.poc.fundamental.dynamicproxy;

import java.lang.reflect.Proxy;

public class MyProxyFactory {

    public static Object CreatProxyedObj(Object target)
    {
        MyInvocationHandler proxy = new MyInvocationHandler(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), proxy);
    }

}

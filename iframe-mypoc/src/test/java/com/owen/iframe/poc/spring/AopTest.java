package com.owen.iframe.poc.spring;

import com.owen.iframe.poc.MainApplication;
import com.owen.iframe.poc.spring.aop.MyAopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={MainApplication.class})
//@EnableAspectJAutoProxy(exposeProxy=true)
public class AopTest {

    @Autowired
    MyAopService service;

    @Test
    public void testAop(){
        service.doSomething("Owen");
    }

    @Test(expected=RuntimeException.class)
    public void testAopException(){
        service.throwException();
    }
}



package com.owen.iframe.poc.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
@Slf4j
public class MyStartupRunner implements CommandLineRunner {
    @Autowired
    private MyAopService aopService;
    @Override
    public void run(String... args) throws Exception {
        aopService.doSomething();
    }
}
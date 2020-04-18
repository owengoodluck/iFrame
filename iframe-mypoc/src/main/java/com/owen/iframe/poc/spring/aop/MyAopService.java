package com.owen.iframe.poc.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MyAopService {

    public String doSomething(String input){
        log.info(">>>>>>>>>>>>>>>>>>>>>>>Do business here: {} <<<<<<<<<<<<<<<<<<<<<",input);
        return "Hello AOP : "+input;
    }

    public String throwException(){
        log.info(">>>>>>>>>>>>>>>>>>>>>>>Mock Exception<<<<<<<<<<<<<<<<<<<<<");
        throw new RuntimeException("mock error");
    }
}

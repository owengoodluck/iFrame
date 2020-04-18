package com.owen.iframe.poc.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MyAopService {

    public String doSomething(){
        log.info("Do something here");
        return "";
    }

}

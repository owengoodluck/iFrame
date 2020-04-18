package com.owen.iframe.poc.controller;

import com.owen.iframe.poc.aop.MyAopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StatusController {
    @Autowired
    private MyAopService service;

    @GetMapping ("/status")
    public String status(){
        log.info("status API is called ");
        this.service.doSomething();
        return "Runing";
    }
}

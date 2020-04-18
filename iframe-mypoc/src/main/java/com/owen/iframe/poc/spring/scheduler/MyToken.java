package com.owen.iframe.poc.spring.scheduler;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

public class MyToken {
    private String token;
    private Date expireTime;

    public MyToken(String token, Date expireTime) {
        this.token = token;
        this.expireTime = expireTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }
}

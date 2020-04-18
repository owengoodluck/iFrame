package com.owen.iframe.poc.spring;

import com.owen.iframe.poc.MainApplication;
import com.owen.iframe.poc.spring.aop.MyAopService;
import com.owen.iframe.poc.spring.scheduler.MyThreadPoolTaskScheduler;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={MainApplication.class})
@EnableScheduling
@EnableAsync
@Slf4j
public class SchedulerTest {
    @Autowired
    private MyThreadPoolTaskScheduler scheduler;

    @Test
    public void testScheduler(){
        int count = 30;
       while (count >0 ){
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           count --;
       }
    }


    @Test
    public void testMyThreadPoolTaskScheduler(){
        int count = 30;
        while (count >0 ){
            try {
                log.info("Latest token: {}",this.scheduler.myToken.getToken());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count --;
        }
    }

}



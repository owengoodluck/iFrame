package com.owen.iframe.poc.spring;

import com.owen.iframe.poc.MainApplication;
import com.owen.iframe.poc.spring.aop.MyAopService;
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
public class SchedulerTest {

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
}



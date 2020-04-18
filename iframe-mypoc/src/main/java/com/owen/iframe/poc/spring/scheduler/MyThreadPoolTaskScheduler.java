package com.owen.iframe.poc.spring.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Slf4j
//@Component
public class MyThreadPoolTaskScheduler {

    public final MyToken myToken;
    private final int poolSize = 5;
    private ThreadPoolTaskScheduler scheduler;

    public MyThreadPoolTaskScheduler(){
        this.scheduler = new ThreadPoolTaskScheduler();
        this.scheduler.setPoolSize(poolSize);
        this.scheduler.initialize();

        myToken = new MyToken(UUID.randomUUID().toString(),new Date(System.currentTimeMillis()+1000*10));

        this.scheduler.schedule(new RetrieveTokenTask(scheduler,myToken),myToken.getExpireTime());
    }

    private class RetrieveTokenTask implements Runnable{
        private TaskScheduler scheduler;
        private MyToken myToken;

        public RetrieveTokenTask(TaskScheduler scheduler, MyToken myToken) {
            this.scheduler = scheduler;
            this.myToken = myToken;
        }

        @Override
        public void run() {
            String newToken = UUID.randomUUID().toString();
            log.info("Retrieve new Token : {}",newToken);
            myToken.setToken(newToken);
            myToken.setExpireTime(new Date(System.currentTimeMillis()+1000* (new Random().nextInt(5))));

            log.info("Token will be expired at {}",myToken.getExpireTime());
            scheduler.schedule(this,myToken.getExpireTime());
        }
    }

}

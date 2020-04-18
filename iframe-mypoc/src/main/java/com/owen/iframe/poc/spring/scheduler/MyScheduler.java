package com.owen.iframe.poc.spring.scheduler;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Configuration      //主要用于标记配置类，兼备Component的效果。
//@EnableScheduling   //开启定时任务
public class MyScheduler {

    //    每隔5秒执行一次：0/5 * * * * ?
    //    每隔1分钟执行一次：0 */1 * * * ?
    //    每天24点执行一次：0 0 0 * * ?
    //    每月1号凌晨1点执行一次：0 0 1 1 * ?
    //    每月最后一天24点执行一次：0 0 24 L * ?
    //    每周星期天凌晨1点实行一次：0 0 1 ? * L
    //    在15分、35分、40分执行一次：0 15,35,40 * * * ?
    //    每天的0点、10点、15点、20点都执行一次：0 0 0,10,15,20 * * ?
    //添加定时任务，每隔3秒执行一次
//    @Scheduled(cron = "0/3 * * * * ?")
    @Async
    protected void cronTask() {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm:ss");
        System.out.println("cronTask 当前时间："+simpleDateFormat.format(new Date()));
    }

    //fixedDelay 的间隔是前次任务的结束与下次任务的开始，也就是上一次执行完成后多少毫秒后执行。
    @Scheduled(fixedDelay = 2000)
    protected void fixedDelayTask() {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm:ss");
        System.out.println("fixedDelayTask 当前时间："+simpleDateFormat.format(new Date()));
        try {
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //fixedRate 两次执行任务时间间隔是任务的开始点，也就是上一次执行开始多少毫秒后执行。
    @Scheduled(fixedRate = 3000)
    @Async
    protected void fixedRateTask() {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm:ss");
        System.out.println("fixedRateTask 当前时间："+simpleDateFormat.format(new Date()));
        try {
            Thread.sleep(new Random().nextInt(3)*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.moudel1.Schedule;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Commit;

/**
 * @title: MultithreadScheduleTask
 * @Author Wy
 * @Date: 2022/8/23 10:47
 * @Version 1.0
 */



import java.time.LocalDateTime;
import java.util.concurrent.BlockingQueue;

/**
 * 多线程定时任务
 */
@Component
@Configuration
@EnableScheduling//开启定时任务
@EnableAsync
public class MultithreadScheduleTask {
    @Async
    @Scheduled(fixedDelay = 1000)  //间隔1秒
    public void first() throws InterruptedException {
        System.out.println("第一个定时任务开始 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());
        System.out.println();
//        Thread.sleep(1000 * 10);
    }

    @Async
    @Scheduled(fixedDelay = 2000)
    public void second() {
        System.out.println("第二个定时任务开始 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());
        System.out.println();
    }
}

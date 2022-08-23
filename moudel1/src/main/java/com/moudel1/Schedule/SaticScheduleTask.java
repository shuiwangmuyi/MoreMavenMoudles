package com.moudel1.Schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * @title: SaticScheduleTask
 * @Author Wy
 * @Date: 2022/8/23 10:45
 * @Version 1.0
 */

/**
 *  主要用于标记配置类，兼备Component的效果
 */
@Configuration
/**
 * 开启定时任务
 */
@EnableScheduling
public class SaticScheduleTask {
    //添加定时任务
    @Scheduled(cron = "0/5 * * * * ?")
    /**
     *  直接指定时间间隔，例如：5秒
     *  @Scheduled(fixedRate=5000)
     */
    private void configureTasks() {
        System.out.println("执行静态定时任务时间: " + LocalDateTime.now());
    }

}


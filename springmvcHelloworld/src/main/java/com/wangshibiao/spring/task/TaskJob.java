package com.wangshibiao.spring.task;

import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Wang Shibiao on 2016/6/27.
 */
@Component
@Lazy(false)
public class TaskJob {
    @Scheduled(fixedDelay = 4000)
    public void job1(){
        System.out.println("任务进行中，当前时间："+new Date());
    }
}

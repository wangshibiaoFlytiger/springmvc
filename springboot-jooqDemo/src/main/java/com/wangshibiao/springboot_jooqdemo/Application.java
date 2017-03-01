package com.wangshibiao.springboot_jooqdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Wang Shibiao on 2017/2/6.
 * 运行方法
 * 1. 仅适用于开发环境
 *  gradle springbootDemo:bootRun
 * 2. 打jar包运行，步骤如下：
 *  1> gradle autobuild  //打jar包以及依赖jar包
 *  2> java -classpath F:\github\gradleProjects\out\build\springbootDemo\dependicies\*;F:\github\gradleProjects\out\build\springbootDemo\libs\* com.wangshibiao.springbootdemo.Application
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}

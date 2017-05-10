package com.wangshibiao.springboot.mybatisdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Wang Shibiao on 2017/2/6.
 */
@SpringBootApplication
@EnableTransactionManagement
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}

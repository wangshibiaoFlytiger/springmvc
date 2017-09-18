package com.wangshibiao.spring.redis;

import com.wangshibiao.spring.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Wang Shibiao on 2017/9/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/appCtx-redis.xml")
public class RedisTest{
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testWrite(){
        redisTemplate.opsForValue().set("redisObject", "sssssssssssssssssssssss");
    }
}

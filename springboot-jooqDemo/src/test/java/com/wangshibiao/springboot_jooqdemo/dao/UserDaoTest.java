package com.wangshibiao.springboot_jooqdemo.dao;

import com.wangshibiao.springboot_jooqdemo.ConfigProperties;
import com.wangshibiao.springboot_jooqdemo.jooq.generated.testdb.tables.pojos.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by Wang Shibiao on 2017/2/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    UserDao userDao;

    @Test
    public void testFindAll() throws Exception {
        //调用自定义dao类的方法
        List<User> userList = userDao.findAll();
        //调用jooq生成的dao类的方法
        userList = userDao.getJooqDao().findAll();
    }
    @Test
    public void testInsert() throws Exception {
        User user = new User(UUID.randomUUID().toString(), 12, "wangsi1", "ae7bb54a-f3f7-11e6-9481-00ff3b946d39");
        userDao.getJooqDao().insert(user);
    }
}
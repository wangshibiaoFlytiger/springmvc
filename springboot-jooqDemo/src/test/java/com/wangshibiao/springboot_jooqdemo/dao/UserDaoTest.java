package com.wangshibiao.springboot_jooqdemo.dao;

import com.wangshibiao.springboot_jooqdemo.ConfigProperties;
import com.wangshibiao.springboot_jooqdemo.jooq.generated.testdb.tables.pojos.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

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
        List<User> userList = userDao.findAll();
    }
}
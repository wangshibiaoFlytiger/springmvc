package com.wangshibiao.springboot.mybatisdemo.dao;

import com.wangshibiao.springboot.mybatisdemo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Wang Shibiao on 2017/4/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional  //启用事务
public class UserDaoTest {
    @Autowired
    UserDao userDao;

    @Test
    @Rollback(false)  //true：测试方法结束后执行数据库回滚，否则不回滚
    public void testInsert() throws Exception {
        User user = new User();
        user.setId("yyy");
        user.setName("name1");
        user.setAge(55);
        Integer ret = userDao.insert(user);
    }

    @Test
    @Rollback(false)
    public void testUpdate() throws Exception {
        User user = new User();
        user.setId("yyy");
        user.setName("name**");
        user.setAge(77);
        Integer ret = userDao.update(user);
    }

    @Test
    @Rollback(false)
    public void testDeleteById() throws Exception {
        Integer ret = userDao.deleteById("yyy");
    }

    @Test
    public void testGetById() throws Exception {
        User user = userDao.getById("09ed6157-f349-11e6-a188-00ff3b946d39");
        System.out.println("d");
    }

    @Test
    public void testFindByName() throws Exception {
        List<User> userList = userDao.findByName("name");
    }
}
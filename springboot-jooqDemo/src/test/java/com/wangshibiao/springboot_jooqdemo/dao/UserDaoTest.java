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

    /**
     * 查询单表所有数据
     * @throws Exception
     */
    @Test
    public void testFindAll() throws Exception {
        //调用自定义dao类的方法
        List<User> userList = userDao.findAll();
        //调用jooq生成的dao类的方法
        userList = userDao.getJooqDao().findAll();
    }

    /**
     * 单表分页查询
     * @throws Exception
     */
    @Test
    public void testFindAllPage() throws Exception {
        Integer pageIndex = 2;
        Integer pageRows = 3;
        List<User> userList = userDao.findAllPage(pageIndex-1, pageRows);
    }

    /**
     * 插入操作
     * @throws Exception
     */
    @Test
    public void testInsert() throws Exception {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setAge(12);
        user.setName("wangsi1");
        user.setOrgid("ae7bb54a-f3f7-11e6-9481-00ff3b946d39");
        userDao.getJooqDao().insert(user);
    }

    /**
     * 更新操作
     * @throws Exception
     */
    @Test
    public void testUpdate() throws Exception {
        User user = userDao.getJooqDao().fetchOneById("a8358d4a-2607-48fc-a520-c3a0a713a914");
        user.setName("李四");
        userDao.getJooqDao().update(user);
    }

    /**
     * 删除操作
     * @throws Exception
     */
    @Test
    public void testDeleteById() throws Exception {
        List<User> userList = userDao.getJooqDao().findAll();
        userDao.getJooqDao().deleteById(userList.get(0).getId());
    }

    /**
     * 单表查询
     * @throws Exception
     */
    @Test
    public void testFetchByName() throws Exception {
        List<User> userList = userDao.getJooqDao().fetchByName("name1");
    }

    /**
     * 多表查询
     * @throws Exception
     */
    @Test
    public void testFindByOrgId() throws Exception {
        List<User> userList = userDao.findByOrgId("ae7bb54a-f3f7-11e6-9481-00ff3b946d39");
    }

    /**
     * 多表分页查询
     * @throws Exception
     */
    @Test
    public void testFindByOrgIdPage() throws Exception {
        Integer pageIndex = 2;
        Integer pageRows = 3;
        List<User> userList = userDao.findByOrgIdPage("ae7bb54a-f3f7-11e6-9481-00ff3b946d39", pageIndex, pageRows);
    }
}
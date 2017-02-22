package com.wangshibiao.springbootdemo.dao;

import com.wangshibiao.springbootdemo.dao.condition.jpacriteria.UserSpec;
import com.wangshibiao.springbootdemo.model.Org;
import com.wangshibiao.springbootdemo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Wang Shibiao on 2017/2/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    UserDao userDao;
    @Autowired
    OrgDao orgDao;

    /**
     * 测试springdatajpa的已实现的方法: save
     * @throws Exception
     */
    @Test
    public void testSave() throws Exception {
        User user = new User();
        user.setName("wangli");
        user.setAge(12);

        //设置关联表
        Org org = orgDao.findAll().get(0);
        user.setOrg(org);
        userDao.save(user);

        //TODO: 以下代码报异常，关联对象不会自动创建
/*        org = new Org();
        org.setName("org2");
        user.setOrg(org);
        userDao.save(user);*/
    }

    /**
     * 测试springdatajpa的已实现的方法: delete
     * @throws Exception
     */
    @Test
    public void testDelete() throws Exception {
        userDao.delete("8f105016-f31a-11e6-a188-00ff3b946d39");
    }

    /**
     * 测试springdatajpa的已实现的方法: findAll
     * @throws Exception
     */
    @Test
    public void testFindAll() throws Exception {
        List<User> userList = userDao.findAll();
    }

    /**
     * 测试自定义的数据库操作：
     * 1. 1个字段做条件
     * 2. 实现方法：按约定定义方法名称
     * @throws Exception
     */
    @Test
    public void testFindById() throws Exception {
        User user = userDao.findById("8f105016-f31a-11e6-a188-00ff3b946d39");
    }

    /**
     * 测试自定义的数据库操作：
     * 1. 1个字段做条件
     * 2. 实现方法：按约定定义方法名称
     * @throws Exception
     */
    @Test
    public void testGetById() throws Exception {
        User user = userDao.getById("0949d7ed-f40d-11e6-9481-00ff3b946d39");
    }

    /**
     * 测试自定义的数据库操作：
     * 1. 多个字段做条件
     * 2. 实现方法：按约定定义方法名称
     * @throws Exception
     */
    @Test
    public void testFindByIdAndAge() throws Exception {
        List<User> user = userDao.findByNameAndAge("name1", 13);
    }

    /**
     * 测试自定义的数据库操作：
     * 实现方法：通过JPQL语句
     * @throws Exception
     */
    @Test
    public void testFindUserByJpql() throws Exception {
        List<User> userList = userDao.findByJpql("wangli");
    }

    /**
     * 测试自定义的数据库操作：
     * 实现方法：通过原生SQL语句
     * @throws Exception
     */
    @Test
    public void testFindUserByOriginalsql() throws Exception {
        List<User> userList = userDao.findByOriginalsql("wangli");
    }

    /**
     * 测试自定义的数据库操作：
     * 实现方法：通过原生SQL做关联表查询
     * @throws Exception
     */
    @Test
    public void testFindByOrgId() throws Exception {
        List<User> userList = userDao.findByOrgId("ae7bb54a-f3f7-11e6-9481-00ff3b946d39");
    }

    /**
     * 分页查询：分页查询
     * @throws Exception
     */
    @Test
    public void testFindUserPage() throws Exception {
        Integer page = 1;
        Integer size = 2;
//        page起始页码从0开始
        Pageable pageable = new PageRequest(page-1, size);
//        springdatajpa已有的函数，进行分页查询
        Page<User> userPage = userDao.findAll(pageable);
//        符合springdatajpa约定的函数，进行分页查询
        userPage = userDao.findByNameAndAge("name1", 13, pageable);
//        JPQL分页查询(单表操作)
        userPage = userDao.findByJpqlOneTable("name1", pageable);
//        JPQL分页查询(多表操作)
        userPage = userDao.findByJpqlManyTable("ae7bb54a-f3f7-11e6-9481-00ff3b946d39", pageable);
//        基于JPA Criteria API，分页查询(单表，无条件查询)
        userPage = userDao.findAll(UserSpec.findAll(), pageable);
//        基于JPA Criteria API，分页查询(单表，条件查询)
        userPage = userDao.findAll(UserSpec.findByName("name1"), pageable);
//        基于JPA Criteria API，分页查询(多表，条件查询)
        userPage = userDao.findAll(UserSpec.findByOrgId("ae7bb54a-f3f7-11e6-9481-00ff3b946d39"), pageable);
    }
}
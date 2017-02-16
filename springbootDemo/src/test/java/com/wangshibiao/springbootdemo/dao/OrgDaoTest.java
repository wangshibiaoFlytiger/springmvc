package com.wangshibiao.springbootdemo.dao;

import com.wangshibiao.springbootdemo.model.Org;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Wang Shibiao on 2017/2/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrgDaoTest {
    @Autowired
    OrgDao orgDao;

    @Test
    public void testSave() throws Exception {
        Org org = new Org();
        org.setName("org1");
        orgDao.save(org);
    }

    @Test
    public void testGetById() throws Exception {
        Org org = orgDao.getById("ae7bb54a-f3f7-11e6-9481-00ff3b946d39");
    }
}
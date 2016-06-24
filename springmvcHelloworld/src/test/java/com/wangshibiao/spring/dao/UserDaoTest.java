package com.wangshibiao.spring.dao;

import com.wangshibiao.spring.BaseTest;
import com.wangshibiao.spring.model.User;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by Wang Shibiao on 2016/6/24.
 */
public class UserDaoTest extends BaseTest{
    @Resource
    UserMapper userMapper;

    @Test
    public void test(){
        User user = userMapper.selectByPrimaryKey(27);
    }

}

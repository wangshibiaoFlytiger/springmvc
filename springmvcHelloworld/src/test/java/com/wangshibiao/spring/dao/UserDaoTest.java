package com.wangshibiao.spring.dao;

import com.wangshibiao.spring.BaseTest;
import com.wangshibiao.spring.model.Org;
import com.wangshibiao.spring.model.User;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Wang Shibiao on 2016/6/24.
 */
public class UserDaoTest extends BaseTest{
    @Resource
    UserMapper userMapper;
    @Resource
    OrgMapper orgMapper;

    @Test
    public void test(){
        User user = userMapper.selectByPrimaryKey(27);
        List orgList = orgMapper.selectByExample(null);
    }



}

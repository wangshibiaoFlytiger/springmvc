package com.wangshibiao.spring.dao;

import com.wangshibiao.spring.BaseTest;
import com.wangshibiao.spring.model.Org;
import com.wangshibiao.spring.model.User;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Wang Shibiao on 2016/6/25.
 */
public class OrgDaoTest extends BaseTest {
    @Resource
    OrgMapper orgMapper;

    @Test
    public void test(){
        //查询机构列表，通过级联查询获取相关用户信息
        List<Org> orgListCascade = orgMapper.selectByOrgStatusCascadeUser(1);
        //查询机构列表，通过懒加载获取相关用户信息
        List orgListLazyLoad = orgMapper.selectByExample(null);
        //查询机构，通过懒加载获取相关用户信息
        Org org = orgMapper.selectByPrimaryKey(1);
        List userList = org.getUserList();
    }
}

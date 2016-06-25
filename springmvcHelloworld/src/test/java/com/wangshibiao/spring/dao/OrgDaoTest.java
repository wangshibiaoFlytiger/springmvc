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
        List<Org> orgList = orgMapper.selectByOrgStatusCascadeUser(1);
    }
}

package com.wangshibiao.spring.dao;

import com.wangshibiao.spring.BaseTest;
import com.wangshibiao.spring.model.Org;
import com.wangshibiao.spring.model.User;
import com.wangshibiao.spring.model.UserExample;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Wang Shibiao on 2016/6/25.
 */
public class MixedDaoTest extends BaseTest {
    @Resource
    OrgMapper orgMapper;
    @Resource
    UserMapper userMapper;

    @Test
    public void findUserListByOrgId(){
        Org org = orgMapper.selectByPrimaryKey(1);

        UserExample userExample = new UserExample();
        userExample.or().andOrg_idEqualTo(org.getId());
        List userList = userMapper.selectByExample(userExample);
    }
}

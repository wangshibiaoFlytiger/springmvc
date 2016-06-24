package com.wangshibiao.spring.service;

import com.wangshibiao.spring.dao.UserMapper;
import com.wangshibiao.spring.model.User;
import com.wangshibiao.spring.model.UserExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Wang Shibiao on 2016/6/5.
 */
@Service
public class UserService {
    @Resource
    UserMapper userMapper;

    public User getUserByUserName(String userName) {
        UserExample userExample = new UserExample();
        userExample.or()
                .andUsernameEqualTo(userName);
        List<User> userList = userMapper.selectByExample(userExample);
        return userList.get(0);
    }
}

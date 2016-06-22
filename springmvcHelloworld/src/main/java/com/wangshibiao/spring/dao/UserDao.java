package com.wangshibiao.spring.dao;

import com.wangshibiao.spring.model.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Wang Shibiao on 2016/6/21.
 */
@Repository
public class UserDao implements IUserDao {

    @Autowired
    public SqlSessionTemplate sqlSession;

    @Override
    public User getUserByUserName(String userName) {
        return (User)sqlSession.selectOne("com.wangshibiao.spring.model.User.getUserByUserName", userName);
    }
}

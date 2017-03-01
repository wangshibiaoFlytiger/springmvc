package com.wangshibiao.springboot_jooqdemo.dao;

import com.wangshibiao.springboot_jooqdemo.jooq.generated.testdb.Tables;
import com.wangshibiao.springboot_jooqdemo.jooq.generated.testdb.tables.pojos.User;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.conf.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by Wang Shibiao on 2017/2/28.
 */
@Repository
public class UserDao{
    @Autowired
    DSLContext dslContext;

    public List<User> findAll(){
        List<User> userList = dslContext.select().from(Tables.USER).fetchInto(User.class);
        return userList;
    }
}

package com.wangshibiao.springboot_jooqdemo.dao;

import com.sun.org.apache.xpath.internal.operations.String;
import com.wangshibiao.springboot_jooqdemo.ConfigProperties;
import jooqgenerated.testdb.Tables;
import jooqgenerated.testdb.tables.pojos.User;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Wang Shibiao on 2017/2/28.
 */
@Repository
public class UserDao extends BaseDao{
    public List<User> findAll(){
        this.init();
        List<User> userList = this.getDslContext().select().from(Tables.USER).fetchInto(User.class);
        return userList;
    }
}

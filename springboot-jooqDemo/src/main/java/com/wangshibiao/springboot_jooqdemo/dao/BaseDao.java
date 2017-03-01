package com.wangshibiao.springboot_jooqdemo.dao;

import com.wangshibiao.springboot_jooqdemo.ConfigProperties;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Wang Shibiao on 2017/3/1.
 */
public class BaseDao {
    @Autowired
    ConfigProperties configProperties;

    private DSLContext dslContext;

    public void init(){
        String userName = configProperties.getUsername();
        String password = configProperties.getPassword();
        String url = configProperties.getUrl();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.setDslContext(DSL.using(conn, SQLDialect.MYSQL));
    }

    public DSLContext getDslContext() {
        return dslContext;
    }

    public void setDslContext(DSLContext dslContext) {
        this.dslContext = dslContext;
    }
}

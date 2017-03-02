package com.wangshibiao.springboot_jooqdemo.dao;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Wang Shibiao on 2017/3/2.
 */
public class BaseDao {
    @Autowired
    DSLContext dslContext;
    @Autowired
    Configuration configuration;
}

package com.wangshibiao.spring.dao;

import com.wangshibiao.spring.dao.template.DbUtilsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Wang Shibiao on 2016/6/5.
 */

@Component
public class EntityDAO {
    @Resource
    DbUtilsTemplate dbUtilsTemplate;

    public DbUtilsTemplate getDbUtilsTemplate() {
        return dbUtilsTemplate;
    }

    public void setDbUtilsTemplate(DbUtilsTemplate dbUtilsTemplate) {
        this.dbUtilsTemplate = dbUtilsTemplate;
    }
}

package com.wangshibiao.springboot_jooqdemo.dao;

import com.wangshibiao.springboot_jooqdemo.jooq.generated.testdb.Tables;
import com.wangshibiao.springboot_jooqdemo.jooq.generated.testdb.tables.pojos.User;
import org.springframework.stereotype.Repository;
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

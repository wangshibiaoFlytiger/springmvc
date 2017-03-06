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
    private com.wangshibiao.springboot_jooqdemo.jooq.generated.testdb.tables.daos.UserDao jooqDao = new com.wangshibiao.springboot_jooqdemo.jooq.generated.testdb.tables.daos.UserDao();

    public com.wangshibiao.springboot_jooqdemo.jooq.generated.testdb.tables.daos.UserDao getJooqDao(){
        jooqDao.setConfiguration(this.configuration);
        return jooqDao;
    }

    public List<User> findAll(){
        List<User> userList = dslContext.select().from(Tables.USER).fetchInto(User.class);
        return userList;
    }

    /**
     * 多表关联查询
     * @return
     */
    public List<User> findByOrgId(String orgId){
        List<User> userList = dslContext.select(Tables.USER.fields())
                .from(Tables.USER)
                .innerJoin(Tables.ORG)
                .on(Tables.USER.ORGID.equal(Tables.ORG.ID))
                .where(Tables.ORG.ID.equal(orgId))
                .fetchInto(User.class);

        return userList;
    }
}

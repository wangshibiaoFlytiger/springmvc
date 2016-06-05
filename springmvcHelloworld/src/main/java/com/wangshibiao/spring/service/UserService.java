package com.wangshibiao.spring.service;

import com.wangshibiao.spring.dao.EntityDAO;
import com.wangshibiao.spring.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Wang Shibiao on 2016/6/5.
 */
@Service
public class UserService {
    @Resource
    EntityDAO entityDAO;

    public EntityDAO getEntityDAO() {
        return entityDAO;
    }

    public void setEntityDAO(EntityDAO entityDAO) {
        this.entityDAO = entityDAO;
    }

    public User findByUsername(String username){
        User user = new User();
        user.setUsername("wangshibiao");
        user.setName("王世彪");
        return user;
    }

    public List findUserList(){

        List list = getEntityDAO().getDbUtilsTemplate().find("select * from user");
        return list;
    }
}

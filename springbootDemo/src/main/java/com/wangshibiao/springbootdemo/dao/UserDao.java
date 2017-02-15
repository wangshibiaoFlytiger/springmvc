package com.wangshibiao.springbootdemo.dao;

import com.wangshibiao.springbootdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Wang Shibiao on 2017/2/13.
 */
public interface UserDao extends JpaRepository<User, String> {
    /**
     * findById的返回类型由User改为List<User>，也能正常运行，框架会自动转换
     * @param id
     * @return
    List<User> findById(String id);*/
    User findById(String id);
    List<User> findByNameAndAge(String name, Integer age);
    @Query("select u from User u where u.name = :name")
    List<User> findBySql(@Param("name") String name);
}

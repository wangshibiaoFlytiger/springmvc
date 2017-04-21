package com.wangshibiao.springboot.mybatisdemo.dao;

import com.wangshibiao.springboot.mybatisdemo.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Wang Shibiao on 2017/4/19.
 */
@Mapper
public interface UserDao {
    @Insert("INSERT INTO user(id, name, age) VALUES(#{id}, #{name}, #{age})")
    int insert(User user);

    @Delete("DELETE FROM user where id = #{id}")
    public int deleteById(String id);

    @Update("UPDATE user set name = #{name}, age = #{age} where id = #{id}")
    public int update(User user);

    @Select("SELECT * FROM user WHERE id = #{id}")
    User getById(@Param("id") String id);

    @Select("SELECT * FROM user WHERE name = #{name}")
    List<User> findByName(@Param("name") String name);
}

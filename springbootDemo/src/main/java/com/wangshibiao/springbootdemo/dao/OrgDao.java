package com.wangshibiao.springbootdemo.dao;

import com.wangshibiao.springbootdemo.model.Org;
import com.wangshibiao.springbootdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Wang Shibiao on 2017/2/13.
 */
public interface OrgDao extends JpaRepository<Org, String> {
    public Org getById(String id);
}

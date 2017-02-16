package com.wangshibiao.springbootdemo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wang Shibiao on 2017/2/13.
 */
@Entity
@Table(name = "Org")
public class Org {
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "guid")
    private String id;

    @Column(nullable = false)
    private String name;

    //TODO: OneToMany没有验证通过
    /*@OneToMany(mappedBy="org")
    private List<User> userList = new ArrayList<User>();

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

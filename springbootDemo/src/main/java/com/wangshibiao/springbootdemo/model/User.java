package com.wangshibiao.springbootdemo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Wang Shibiao on 2017/2/13.
 */
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "guid")
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    //TODO: 采用懒加载后,取关联表数据报异常:(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(
            name = "orgId",
            nullable = false,
            //不建立外键
            foreignKey = @ForeignKey(name = "none"))
    private Org org;

    public Org getOrg() {
        return org;
    }

    public void setOrg(Org org) {
        this.org = org;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

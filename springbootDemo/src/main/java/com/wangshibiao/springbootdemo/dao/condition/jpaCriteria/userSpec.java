package com.wangshibiao.springbootdemo.dao.condition.jpacriteria;

import com.wangshibiao.springbootdemo.model.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

/**
 * Created by Wang Shibiao on 2017/2/22.
 * 基于JPA Criteria API，定义user表的数据库查询条件
 */
public class UserSpec{
    /**
     * 查询所有用户：没有设置查询条件
     * @return
     */
    public static Specification<User> findAll(){
        return new Specification<User>(){

            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return null;
            }
        };
    }

    /**
     * 查询用户：根据name条件查询
     * @param name
     * @return
     */
    public static Specification<User> findByName(String name){
        return new Specification<User>(){

            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate predicate = cb.equal(root.get("name"), name);
                query.where(predicate);
                return null;
            }
        };
    }

    /**
     * 查询用户：多表关联查询
     * @param orgId
     * @return
     */
    public static Specification<User> findByOrgId(String orgId){
        return new Specification<User>(){

            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate predicate = cb.equal(root.join("org").get("id"), orgId);
                query.where(predicate);
                return query.getRestriction();
            }
        };
    }
}

package com.wangshibiao.spring.shiro;

import com.wangshibiao.spring.model.User;
import com.wangshibiao.spring.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * Created by Wang Shibiao on 2016/8/1.
 */

/**
 * shiro Realm类：
 * 用户的认证逻辑：doGetAuthenticationInfo
 * 用户的授权逻辑：doGetAuthorizationInfo
 */
@Component
public class MyShiroRealm extends AuthorizingRealm {
    @Resource
    UserService userService;

    /**
     * 返回认证信息(封装了正确的用户信息)：
     * 如果客户端输入的用户信息和正确的用户信息匹配，则shiro通过认证，否则认证失败
     * @param authenticationToken
     * @return
     * @throws AuthenticationException 客户端输入的用户信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("进入doGetAuthenticationInfo");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;
        String username =  usernamePasswordToken.getUsername();
        if (!StringUtils.isEmpty(username)){
            User user = userService.getUserByUserName(username);
            if (!StringUtils.isEmpty(user)){
                //查询出正确的账号和密码
                SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
                return simpleAuthenticationInfo;
            }
        }

        return null;
    }

    /**
     * 返回当前用户的权限列表:
     * 根据需要灵活编写授权逻辑，加载授权资源
     * @param principalCollection 客户端输入的账号和密码信息
     * @return  如果
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("进入doGetAuthorizationInfo");
        //从认证信息中取出账号
        String username = (String)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        /**
         * 返回当前用户的授权资源(即权限)
         */
        info.addStringPermission("/user/userList.json");
        return info;
    }
}

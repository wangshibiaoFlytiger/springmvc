package com.wangshibiao.spring.filter;

import com.sun.org.glassfish.external.statistics.annotations.Reset;
import com.wangshibiao.spring.model.User;
import com.wangshibiao.spring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by Wang Shibiao on 2016/7/5.
 */
@Component
public class RequestFilter extends SpringBeanAutowiringSupport implements Filter {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.debug("进入RequestFilter doFilter");
        String token = servletRequest.getParameter("token");
        String username = servletRequest.getParameter("username");
        if (!StringUtils.isEmpty(username)){
            User user = userService.getUserByUserName(username);
            if (!StringUtils.isEmpty(user))
                System.out.println("RequestFilter username:"+user.getUsername());
        }

        if(token.equals("123"))
            filterChain.doFilter(servletRequest, servletResponse);
        else {
            logger.debug("请求中需传入参数token=123，本过滤器才会放行。");
        }
    }

    @Override
    public void destroy() {

    }
}

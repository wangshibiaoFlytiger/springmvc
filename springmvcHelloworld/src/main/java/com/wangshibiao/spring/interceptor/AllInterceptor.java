package com.wangshibiao.spring.interceptor;

import com.wangshibiao.spring.model.User;
import com.wangshibiao.spring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Wang Shibiao on 2016/7/5.
 */

/**
 * 拦截所有请求
 */
@Component
public class AllInterceptor extends HandlerInterceptorAdapter {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    UserService userService;

    /**
     * 请求进入controller之前进行拦截
     * 经测试发现：如果请求地址没有通过shiro的认证或授权，拦截器收不到请求参数
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("进入拦截器Interceptor preHandle");

        String token = request.getParameter("token");
        String username = request.getParameter("username");
        if (!StringUtils.isEmpty(username)){
            User user = userService.getUserByUserName(username);
            if (!StringUtils.isEmpty(user))
                System.out.println("AllInterceptor username:"+user.getUsername());
        }

        if("123".equals(token))
            return true;
        else {
            logger.debug("请求中需传入参数token=123，本拦截器才会放行。");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("请求中需传入参数token=123，本拦截器才会放行。");
            return false;
        }
    }

    /**
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.debug("进入拦截器Interceptor postHandle");
    }

    /**
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行，
     * 这个方法的主要作用是用于清理资源的，当然这个方法也只能在当前这个Interceptor的preHandle方法的返回值为true时才会执行。
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.debug("进入拦截器Interceptor afterCompletion");
    }
}

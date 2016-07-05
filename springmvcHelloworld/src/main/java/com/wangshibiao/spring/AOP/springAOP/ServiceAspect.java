package com.wangshibiao.spring.AOP.springAOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Wang Shibiao on 2016/7/4.
 */

/**
 * 通过spring AOP创建aspect
 */
@Component
@Aspect
public class ServiceAspect {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.wangshibiao.spring.service..*.*(..))")
    public void serviceMethod(){}

    @Before("serviceMethod ()")
    public void serviceBefore(JoinPoint joinPoint){
        String para = Arrays.toString(joinPoint.getArgs());
        logger.debug("ServiceAspect @Before: "+joinPoint.getTarget().getClass().getName()+":"+
                        joinPoint.getSignature().getName()+":"+
                        para);
    }

    @After("serviceMethod ()")
    public void serviceAfter(JoinPoint joinPoint){
        String para = Arrays.toString(joinPoint.getArgs());
        logger.debug("ServiceAspect @After: "+joinPoint.getTarget().getClass().getName()+":"+
                joinPoint.getSignature().getName()+":"+
                para);
    }

    @AfterReturning("serviceMethod ()")
    public void serviceAfterReturning(JoinPoint joinPoint){
        String para = Arrays.toString(joinPoint.getArgs());
        logger.debug("ServiceAspect @AfterReturning: "+joinPoint.getTarget().getClass().getName()+":"+
                joinPoint.getSignature().getName()+":"+
                para);
    }

    @AfterThrowing("serviceMethod ()")
    public void serviceThrowing(JoinPoint joinPoint){;
        String para = Arrays.toString(joinPoint.getArgs());
        logger.debug("ServiceAspect @AfterThrowing: "+joinPoint.getTarget().getClass().getName()+":"+
                joinPoint.getSignature().getName()+":"+
                para);
    }
}

package com.jiangc.bean;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

import com.jiangchengframework.aop.advice.AroundAdvice;
import com.jiangchengframework.aop.annotation.Aspect;
import com.jiangchengframework.aop.annotation.Order;

@Slf4j
@Order(2)
@Aspect(pointcut = "@within(com.slimframework.core.annotation.Controller)")
public class SlimAspect2 implements AroundAdvice {
    @Override
    public void before(Class<?> clz, Method method, Object[] args) throws Throwable {
        log.info("-----------before  SlimAspect2-----------");
        log.info("class: {}, method: {}", clz.getName(), method.getName());
    }

    @Override
    public void afterReturning(Class<?> clz, Object returnValue, Method method, Object[] args) throws Throwable {
        log.info("-----------after  SlimAspect2-----------");
        log.info("class: {}, method: {}", clz, method.getName());
    }

    @Override
    public void afterThrowing(Class<?> clz, Method method, Object[] args, Throwable e) {
        log.error("-----------error  SlimAspect2-----------");
        log.error("class: {}, method: {}, exception: {}", clz, method.getName(), e.getMessage());
    }
}

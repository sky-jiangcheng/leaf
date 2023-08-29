package com.jiangchengframework.bean;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

import com.jiangchengframework.aop.advice.AroundAdvice;
import com.jiangchengframework.aop.annotation.Aspect;
import com.jiangchengframework.aop.annotation.Order;

@Slf4j
//
//v1
//@Aspect(target = Controller.class)
//v2
//@Aspect(pointcut = "execution(* com.jiangchengframework.bean.SlimController.helloForAspect(..))")
//v3
@Order(1)
@Aspect(pointcut = "@within(com.jiangchengframework.core.annotation.Controller)")
public class SlimAspect implements AroundAdvice {
    @Override
    public void afterReturning(Class<?> clz, Object returnValue, Method method, Object[] args) throws Throwable {
        //log.info("After  SlimAspect ----> class: {}, method: {}", clz, method.getName());
        log.info("-----------after  SlimAspect-----------");
        log.info("class: {}, method: {}", clz.getName(), method.getName());
    }

    @Override
    public void before(Class<?> clz, Method method, Object[] args) throws Throwable {
        //log.info("Before  SlimAspect ----> class: {}, method: {}", clz.getName(), method.getName());
        log.info("-----------before  SlimAspect-----------");
        log.info("class: {}, method: {}", clz.getName(), method.getName());
    }

    @Override
    public void afterThrowing(Class<?> clz, Method method, Object[] args, Throwable e) {
        //log.error("Error  SlimAspect ----> class: {}, method: {}, exception: {}", clz, method.getName(), e.getMessage());
        log.error("-----------error  SlimAspect-----------");
        log.error("class: {}, method: {}, exception: {}", clz, method.getName(), e.getMessage());
    }
}

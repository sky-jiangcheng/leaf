package com.slimframework.bean;

import com.slimframework.aop.advice.AroundAdvice;
import com.slimframework.aop.annotation.Aspect;
import com.slimframework.core.annotation.Controller;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

@Slf4j
@Aspect(target = Controller.class)
public class SlimAspect implements AroundAdvice {
    @Override
    public void afterReturning(Class<?> clz, Object returnValue, Method method, Object[] args) throws Throwable {
        log.info("After  SlimAspect ----> class: {}, method: {}", clz, method.getName());
    }

    @Override
    public void before(Class<?> clz, Method method, Object[] args) throws Throwable {
        log.info("Before  SlimAspect ----> class: {}, method: {}", clz.getName(), method.getName());
    }

    @Override
    public void afterThrowing(Class<?> clz, Method method, Object[] args, Throwable e) {
        log.error("Error  SlimAspect ----> class: {}, method: {}, exception: {}", clz, method.getName(), e.getMessage());
    }
}

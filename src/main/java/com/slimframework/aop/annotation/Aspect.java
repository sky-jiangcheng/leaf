package com.slimframework.aop.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    /**
     * V1 没有使用 aspectJ的简单用法
     * 目标代理类的范围
     */
    //Class<? extends Annotation> target();

    /**
     * V2 使用 aspectJ 的灵活方式
     * 切点表达式
     */
    String pointcut() default "";
}

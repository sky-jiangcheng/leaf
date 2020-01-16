package com.slimframework.aop;

import com.slimframework.ProxyCreator;
import com.slimframework.aop.advice.Advice;
import com.slimframework.aop.annotation.Aspect;
import com.slimframework.core.BeanContainer;
import lombok.extern.slf4j.Slf4j;

/**
 * Aop执行器
 */
@Slf4j
public class Aop {
    /**
     * bean容器
     */
    private BeanContainer beanContainer;

    public Aop() {
        beanContainer = BeanContainer.getInstance();
    }

    /*public void doAop() {
        beanContainer.getClassesBySuper(Advice.class)
                .stream()
                .filter(clz -> clz.isAnnotationPresent(Aspect.class))
                .forEach(clz -> {
                    final Advice advice = (Advice) beanContainer.getBean(clz);
                    Aspect aspect = clz.getAnnotation(Aspect.class);
                    beanContainer.getClassesByAnnotation(aspect.target())
                            .stream()
                            .filter(target -> !Advice.class.isAssignableFrom(target))
                            .filter(target -> !target.isAnnotationPresent(Aspect.class))
                            .forEach(target -> {
                                ProxyAdvisor advisor = new ProxyAdvisor(advice);
                                Object proxyBean = ProxyCreator.createProxy(target, advisor);
                                beanContainer.addBean(target, proxyBean);
                            });
                });
    }*/

    public void doAop() {
        beanContainer.getClassesBySuper(Advice.class)
                .stream()
                .filter(clz -> clz.isAnnotationPresent(Aspect.class))
                .map(this::createProxyAdvisor)
                .forEach(proxyAdvisor -> beanContainer.getClasses()
                        .stream()
                        .filter(target -> !Advice.class.isAssignableFrom(target))
                        .filter(target -> !target.isAnnotationPresent(Aspect.class))
                        .forEach(target -> {
                            if (proxyAdvisor.getPointcut().matches(target)) {
                                Object proxyBean = ProxyCreator.createProxy(target, proxyAdvisor);
                                beanContainer.addBean(target, proxyBean);
                            }
                        }));
    }

    /**
     * 通过Aspect切面类创建代理通知类
     */
    private ProxyAdvisor createProxyAdvisor(Class<?> aspectClass) {
        String expression = aspectClass.getAnnotation(Aspect.class).pointcut();
        ProxyPointcut proxyPointcut = new ProxyPointcut();
        proxyPointcut.setExpression(expression);
        Advice advice = (Advice) beanContainer.getBean(aspectClass);
        return new ProxyAdvisor(advice, proxyPointcut);
    }
}

package com.slimframework.aop;

import com.slimframework.aop.advice.Advice;
import com.slimframework.aop.advice.AfterReturningAdvice;
import com.slimframework.aop.advice.MethodBeforeAdvice;
import com.slimframework.aop.advice.ThrowsAdvice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProxyAdvisor {

    /**
     * 通知
     */
    private Advice advice;

    /**
     * AspectJ表达式切点匹配器
     */
    private ProxyPointcut pointcut;

    /**
     * 执行代理方法
     */
    public Object doProxy(Object target, Class<?> targetClass, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object result = null;

        // 使用 aspectJ 通过 Aspect 中的pointcut 来进行判断
        if (!pointcut.matches(method)) {
            return proxy.invokeSuper(target, args);
        }

        if (advice instanceof MethodBeforeAdvice){
            ((MethodBeforeAdvice) advice).before(targetClass,method,args);
        }

        try {
            //执行目标类的方法
            result = proxy.invokeSuper(target,args);
            if (advice instanceof AfterReturningAdvice){
                ((AfterReturningAdvice) advice).afterReturning(targetClass,result,method,args);
            }
        } catch (Exception e){
            if (advice instanceof ThrowsAdvice){
                ((ThrowsAdvice) advice).afterThrowing(targetClass,method,args,e);
            } else {
                throw new Throwable(e);
            }
        }

        return result;
    }
}

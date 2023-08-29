package com.jiangchengframework.bean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import com.jiangchengframework.aop.Aop;
import com.jiangchengframework.core.BeanContainer;
import com.jiangchengframework.ioc.Ioc;

@Slf4j
public class AopTest {
    @Test
    public void doAop(){
        BeanContainer beanContainer = BeanContainer.getInstance();
        beanContainer.loadBeans("com.jiangchengframework");
        new Aop().doAop();
        new Ioc().doIoc();
        SlimController controller = (SlimController) beanContainer.getBean(SlimController.class);
        controller.hello();
        //controller.helloForAspect();
    }
}

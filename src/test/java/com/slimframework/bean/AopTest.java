package com.slimframework.bean;

import com.slimframework.aop.Aop;
import com.slimframework.core.BeanContainer;
import com.slimframework.ioc.Ioc;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class AopTest {
    @Test
    public void doAop(){
        BeanContainer beanContainer = BeanContainer.getInstance();
        beanContainer.loadBeans("com.slimframework");
        new Aop().doAop();
        new Ioc().doIoc();
        SlimController controller = (SlimController) beanContainer.getBean(SlimController.class);
        controller.hello();
        //controller.helloForAspect();
    }
}

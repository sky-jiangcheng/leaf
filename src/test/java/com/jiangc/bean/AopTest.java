package com.jiangc.bean;

import com.jiangc.aop.Aop;
import com.jiangc.core.BeanContainer;
import com.jiangc.ioc.Ioc;
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

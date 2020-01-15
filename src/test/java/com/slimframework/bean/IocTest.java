package com.slimframework.bean;

import com.slimframework.core.BeanContainer;
import com.slimframework.ioc.Ioc;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class IocTest {
    @Test
    public void doIoc(){
        BeanContainer beanContainer = BeanContainer.getInstance();
        beanContainer.loadBeans("com.slimframework");
        new Ioc().doIoc();
        SlimController slimController = (SlimController) beanContainer.getBean(SlimController.class);
        slimController.hello();
    }
}

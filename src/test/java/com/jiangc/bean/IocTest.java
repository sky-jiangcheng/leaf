package com.jiangc.bean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import com.jiangchengframework.core.BeanContainer;
import com.jiangchengframework.ioc.Ioc;

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

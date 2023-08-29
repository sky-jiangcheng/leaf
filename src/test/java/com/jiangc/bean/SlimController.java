package com.jiangc.bean;

import com.jiangchengframework.core.annotation.Controller;
import com.jiangchengframework.ioc.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SlimController {
    @Autowired
    private SlimService slimService;

    public void hello(){
        log.info(slimService.helloworld());
    }

    public void helloForAspect() {
        log.info("Hello Aspectj");
    }
}

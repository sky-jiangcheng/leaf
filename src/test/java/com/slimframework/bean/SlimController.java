package com.slimframework.bean;

import com.slimframework.core.annotation.Controller;
import com.slimframework.ioc.annotation.Autowired;
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

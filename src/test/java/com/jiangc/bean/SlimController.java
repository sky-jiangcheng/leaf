package com.jiangc.bean;

import com.jiangc.core.annotation.Controller;
import com.jiangc.ioc.annotation.Autowired;
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

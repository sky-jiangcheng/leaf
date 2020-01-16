package com.sample;

import com.jiangc.core.annotation.Controller;
import com.jiangc.mvc.annotation.RequestMapping;
import com.jiangc.mvc.annotation.ResponseBody;

@Controller
@RequestMapping
public class LeafController {
    @RequestMapping
    @ResponseBody
    public String hello(){
        return "hello leaf";
    }
}

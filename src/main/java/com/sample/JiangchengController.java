package com.sample;

import com.jiangchengframework.core.annotation.Controller;
import com.jiangchengframework.mvc.annotation.RequestMapping;
import com.jiangchengframework.mvc.annotation.ResponseBody;

@Controller
@RequestMapping
public class JiangchengController {
    @RequestMapping
    @ResponseBody
    public String hello(){
        return "hello leaf";
    }
}

package com.jiangc.bean;

import com.jiangchengframework.core.annotation.Service;

@Service
public class SlimServiceImpl implements SlimService {
    @Override
    public String helloworld() {
        return "hello world";
    }
}

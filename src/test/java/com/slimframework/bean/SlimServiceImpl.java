package com.slimframework.bean;

import com.slimframework.core.annotation.Service;

@Service
public class SlimServiceImpl implements SlimService {
    @Override
    public String helloworld() {
        return "hello world";
    }
}

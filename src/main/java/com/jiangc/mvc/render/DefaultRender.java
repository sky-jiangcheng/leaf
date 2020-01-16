package com.jiangc.mvc.render;

import com.jiangc.mvc.RequestHandlerChain;
import com.jiangc.mvc.handler.Render;

/**
 * 默认渲染 200
 */
public class DefaultRender implements Render {
    @Override
    public void render(RequestHandlerChain handlerChain) throws Exception {
        int status = handlerChain.getResponseStatus();
        handlerChain.getResponse().setStatus(status);
    }
}

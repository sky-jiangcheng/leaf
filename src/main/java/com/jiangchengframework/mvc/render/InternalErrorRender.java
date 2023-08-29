package com.jiangchengframework.mvc.render;

import javax.servlet.http.HttpServletResponse;

import com.jiangchengframework.mvc.RequestHandlerChain;

/**
 * 渲染500
 */
public class InternalErrorRender implements Render {
    @Override
    public void render(RequestHandlerChain handlerChain) throws Exception {
        handlerChain.getResponse().sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
}

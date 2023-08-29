package com.jiangchengframework.mvc.render;

import javax.servlet.http.HttpServletResponse;

import com.jiangchengframework.mvc.RequestHandlerChain;

/**
 * 渲染404
 */
public class NotFoundRender implements Render {
    @Override
    public void render(RequestHandlerChain handlerChain) throws Exception {
        handlerChain.getResponse().sendError(HttpServletResponse.SC_NOT_FOUND);
    }
}

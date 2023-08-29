package com.jiangchengframework.mvc.handler;

import com.jiangchengframework.mvc.RequestHandlerChain;

/**
 * 请求执行器 Handler
 */
public interface Handler {
    /**
     * 请求的执行器
     */
    boolean handle(final RequestHandlerChain handlerChain) throws Exception;
}
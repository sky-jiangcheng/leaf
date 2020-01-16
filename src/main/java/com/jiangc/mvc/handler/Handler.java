package com.jiangc.mvc.handler;

import com.jiangc.mvc.RequestHandlerChain;

/**
 * 请求执行器 Handler
 */
public interface Handler {
    /**
     * 请求的执行器
     */
    boolean handle(final RequestHandlerChain handlerChain) throws Exception;
}
package com.jiangc.mvc;

import com.jiangc.mvc.handler.*;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * DispatcherServlet 所有http请求都由此Servlet转发
 */
@Slf4j
public class DispatcherServlet extends HttpServlet {

    //v1

    //private ControllerHandler controllerHandler = new ControllerHandler();

    //private ResultRender resultRender = new ResultRender();

    /**
     * 执行请求
     */
    /*@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求编码方式
        req.setCharacterEncoding("UTF-8");
        //获取请求方法和请求路径
        String requestMethod = req.getMethod();
        String requestPath = req.getPathInfo();
        log.info("[SlimConfig] {} {}", requestMethod, requestPath);
        if (requestPath.endsWith("/")) {
            requestPath = requestPath.substring(0, requestPath.length() - 1);
        }

        ControllerInfo controllerInfo = controllerHandler.getController(requestMethod, requestPath);
        log.info("{}", controllerInfo);
        if (null == controllerInfo) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        resultRender.invokeController(req, resp, controllerInfo);
    }*/

    //v2

    /**
     * 初始化Servlet
     */
    @Override
    public void init() throws ServletException {
        HANDLER.add(new PreRequestHandler());
        HANDLER.add(new SimpleUrlHandler(getServletContext()));
        HANDLER.add(new JspHandler(getServletContext()));
        HANDLER.add(new ControllerHandler());
    }

    /**
     * 请求执行链
     */
    private final List<Handler> HANDLER = new ArrayList<>();

    /**
     * 执行请求
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestHandlerChain handlerChain = new RequestHandlerChain(HANDLER.iterator(), req, resp);
        handlerChain.doHandlerChain();
        handlerChain.doRender();
    }
}
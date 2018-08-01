package com.demo.controller;

import com.demo.interceptor.BlogInterceptor;
import com.demo.service.BlogService;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * <p>
 * BlogController
 * 所有 sql 与业务逻辑写在 Model 或 Service 中，不要写在 Controller 中，养成好习惯，有利于大型项目的开发与维护
 */
@Before(BlogInterceptor.class)
public class BlogController extends Controller {

    BlogService service = BlogService.me;

    public void index() {

    }

    public void add() {
    }


}



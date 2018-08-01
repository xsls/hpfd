package com.demo.controller;

import com.demo.service.LoginService;
import com.jfinal.core.Controller;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * <p>
 * LoginController
 */
public class LoginController extends Controller {

    LoginService service = LoginService.me;

    public void index() {
        setAttr("userList", service.paginate(getParaToInt(0, 1), 10).getList());
        render("login.html");
    }
}




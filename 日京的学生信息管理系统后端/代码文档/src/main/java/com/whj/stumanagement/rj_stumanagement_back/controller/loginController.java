package com.whj.stumanagement.rj_stumanagement_back.controller;

import com.whj.stumanagement.rj_stumanagement_back.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stu")
public class loginController {
    @Autowired
    private StuService stuService;
    @RequestMapping(value = "/login",produces = "application/json;charset=utf-8")
    public List login(HttpServletRequest request, @RequestParam("sname") String sname, @RequestParam("spwd") String spwd){
        int code=404;
        boolean res = stuService.login(sname, spwd);
        if(res) {
            code = 200;
            System.out.println("登录成功");
//            定义session对象并把数据存入session
            HttpSession session = request.getSession();
            session.setAttribute("sname",sname);
            session.setAttribute("spwd",spwd);
        }else
            System.out.println("登陆失败，用户名或密码错误");
//        返回状态码和登录名
        ArrayList<Object> result = new ArrayList<>();
        result.add(0,code);
        result.add(1,sname);
        return result;
    }
}

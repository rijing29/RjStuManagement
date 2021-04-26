package com.whj.stumanagement.rj_stumanagement_back.controller;

import com.whj.stumanagement.rj_stumanagement_back.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stu")
public class loginController {
    @Autowired
    private StuService stuService;
    @RequestMapping(value = "/login",produces = "application/json;charset=utf-8")
    public int login(@RequestParam("sname") String sname,@RequestParam("spwd") String spwd){
        int code=404;
        boolean res = stuService.login(sname, spwd);
        if(res) {
            code = 200;
            System.out.println("登录成功");
        }else
            System.out.println("登陆失败");
        return code;
    }
}

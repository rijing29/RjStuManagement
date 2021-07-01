package com.whj.stumanagement.rj_stumanagement_back.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/stu")
public class getSession {
    @Autowired
    HttpServletRequest request; //通过注解获取一个request,Autowired的注解少不的
    @RequestMapping(value = "/getName",produces = "application/json;charset=utf-8" )
    public String getName(HttpSession session){
        String sname = (String) session.getAttribute("sname");
        return sname;
    }
}



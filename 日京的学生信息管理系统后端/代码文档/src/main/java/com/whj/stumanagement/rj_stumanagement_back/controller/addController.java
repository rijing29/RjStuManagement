package com.whj.stumanagement.rj_stumanagement_back.controller;

import com.whj.stumanagement.rj_stumanagement_back.entity.Stu;
import com.whj.stumanagement.rj_stumanagement_back.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller //和restcontroller一样都可以
@RequestMapping("/stu")
public class addController {
    @Autowired
    private StuService stuService;
    @RequestMapping(value = "/add",produces = "application/json;charset=utf-8" )
    public void add(HttpServletRequest request, HttpServletResponse response){
//       1.获取从前端传来的数据
        String sname = request.getParameter("sname");
        int sno = Integer.parseInt(request.getParameter("sno"));
        int sage = Integer.parseInt(request.getParameter("sage"));
        String saddress = request.getParameter("saddress");
        String spwd = request.getParameter("spwd");
//        2.封装成stu对象
        Stu student=new Stu(sno,sname,sage,saddress,spwd);
        System.out.println("从前端传回来的student是："+student);
//        3.调用service方法
        stuService.insert(student);
    }
}

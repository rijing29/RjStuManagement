package com.whj.stumanagement.rj_stumanagement_back.controller;

import com.whj.stumanagement.rj_stumanagement_back.entity.Stu;
import com.whj.stumanagement.rj_stumanagement_back.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stu")
public class registerController {
    @Autowired
    private StuService stuService;
    @RequestMapping(value = "/register",produces = "application/json;charset=utf-8" )
    public int register(@RequestParam("sno") int sno,
                         @RequestParam("sname") String sname,
                         @RequestParam("sage") int sage,
                         @RequestParam("saddress") String saddress,
                         @RequestParam("spwd") String spwd){
        int code=404;
        Stu student=new Stu(sno,sname,sage,saddress,spwd);
        boolean res = stuService.insert(student);
        if(res){
            code=200;
            System.out.println("新注册的学生"+student);
        }
        return code;
    }
}

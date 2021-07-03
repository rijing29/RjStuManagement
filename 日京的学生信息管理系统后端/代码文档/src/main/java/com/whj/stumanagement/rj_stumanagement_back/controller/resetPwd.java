package com.whj.stumanagement.rj_stumanagement_back.controller;

import com.whj.stumanagement.rj_stumanagement_back.entity.Stu;
import com.whj.stumanagement.rj_stumanagement_back.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* Description:修改密码
* date: 2021/7/2 15:20
* @author: whj
* @method:
*/

@Controller
@RequestMapping("/stu")
public class resetPwd {
    @Autowired
    private StuService stuService;
//    修改密码
    @RequestMapping(value = "/resetPwd",produces = "application/json;charset=utf-8")
    @ResponseBody
    public int resetPwd(@RequestParam("sno") int sno,
                         @RequestParam("spwd") String spwd){
        boolean res = stuService.resetPwd(sno, spwd);
        int code=404;
        if(res){
            code=200;
            System.out.println("密码修改成功");
        }
        return code;
    }
//    获得修改密码的sno
    @RequestMapping(value="/getSno",produces = "application/json;charset=utf-8")
    @ResponseBody
    public int getSno(@RequestParam("sname") String sname){
        int sno = stuService.getSno(sname);
        System.out.println("修改密码要得到的："+sno);
        return sno;
    }
}

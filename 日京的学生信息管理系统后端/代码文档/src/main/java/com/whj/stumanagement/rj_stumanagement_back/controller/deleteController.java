package com.whj.stumanagement.rj_stumanagement_back.controller;

import com.whj.stumanagement.rj_stumanagement_back.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@RestController
@RequestMapping("/stu")
public class deleteController {
    @Autowired
    private StuService stuService;
    @RequestMapping(value = "/del",produces = "application/json;charset=utf-8" )
    public void delete(@RequestParam("sno") int sno){
//        int sno = Integer.parseInt(request.getParameter("sno"));
        System.out.println("删除中从前端返回来的学号："+sno);
        stuService.deleteByPrimaryKey(sno);
    }
}

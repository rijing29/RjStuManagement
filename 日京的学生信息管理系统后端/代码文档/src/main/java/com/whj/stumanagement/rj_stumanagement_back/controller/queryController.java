package com.whj.stumanagement.rj_stumanagement_back.controller;

import com.alibaba.fastjson.JSON;
import com.whj.stumanagement.rj_stumanagement_back.entity.Stu;
import com.whj.stumanagement.rj_stumanagement_back.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/stu")
public class queryController {
    @Autowired
    private StuService stuService;
    @RequestMapping(value = "/StuDisplay",produces = "application/json;charset=utf-8" )
    public List<Stu> list(){
        List<Stu> students = stuService.QueryAllStudents();
        for (int i=0;i<students.size();i++){
            System.out.println("从数据库返回来的值：");
            System.out.println(students.get(i));
        }
        return students;
    }
}

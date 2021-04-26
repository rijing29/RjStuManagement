package com.whj.stumanagement.rj_stumanagement_back.controller;

import com.whj.stumanagement.rj_stumanagement_back.entity.Stu;
import com.whj.stumanagement.rj_stumanagement_back.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/stu")
public class paginationControler {
    @Autowired
    private StuService stuService;
    @RequestMapping(value = "/stupage",produces = "application/json;charset=utf-8" )
    public List<Stu> Pagination(@RequestParam("currPage") int currPage,
                                @RequestParam("pageSize") int pageSize){
        List<Stu> stuList = stuService.Pagination(currPage, pageSize);
        System.out.println("后台分页中的学生信息：");
        System.out.println(stuList);
        return stuList;
    }
}

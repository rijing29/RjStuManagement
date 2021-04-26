package com.whj.stumanagement.rj_stumanagement_back.controller;

import com.whj.stumanagement.rj_stumanagement_back.entity.Stu;
import com.whj.stumanagement.rj_stumanagement_back.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/stu")
public class updateController {
    @Autowired
    private StuService stuService;
    @RequestMapping(value = "/update",produces = "html/plain;charset=utf-8" )
    public void update(HttpServletRequest request, HttpServletResponse response){
        String sname = request.getParameter("sname");
        int sno = Integer.parseInt(request.getParameter("sno"));
        int sage = Integer.parseInt(request.getParameter("sage"));
        String saddress = request.getParameter("saddress");
        String spwd = request.getParameter("spwd");
        Stu stu = new Stu(sno,sname, sage, saddress, spwd);
        System.out.println("更新中从前端返回来的值："+stu+"--"+sno);
        stuService.updateByPrimaryKey(stu);
    }
}

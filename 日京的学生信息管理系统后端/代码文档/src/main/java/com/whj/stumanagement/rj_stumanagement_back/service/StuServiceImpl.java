package com.whj.stumanagement.rj_stumanagement_back.service;

import com.whj.stumanagement.rj_stumanagement_back.entity.Stu;
import com.whj.stumanagement.rj_stumanagement_back.mapper.StuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StuServiceImpl implements StuService{
    @Autowired
    private StuMapper stuMapper;

    public StuMapper getStuMapper() {
        return stuMapper;
    }
    public void setStuMapper(StuMapper stuMapper) {
        this.stuMapper = stuMapper;
    }
    //删除
    public boolean deleteByPrimaryKey(Integer sno) {
        boolean flag=false;
        int i = stuMapper.deleteByPrimaryKey(sno);
        if(i>0)
            flag=true;
        return flag;
    }
    //新增
    public boolean insert(Stu record) {
        boolean flag=false;
        int i = stuMapper.insert(record);
        if(i>0)
            flag=true;
        return flag;
    }
    //查询
    public List<Stu> QueryAllStudents() {
        List<Stu> stus = stuMapper.queryAllStudents();
        return stus;
    }
    //更新
    public boolean updateByPrimaryKey(Stu record) {
        boolean flag=false;
        int i = stuMapper.updateByPrimaryKey(record);
        if(i>0)
            flag=true;
        return flag;
    }

    //登陆验证
    public boolean login(String sname, String spwd) {
        boolean flag=false;
        Stu stu = stuMapper.login(sname, spwd);
        if(stu!=null)
            flag=true;
        return flag;
    }

//    分页查询
    public List<Stu> Pagination(int currPage, int pageSize) {
        System.out.println("service中的内容");
        Map<String, Object> data = new HashMap();
        data.put("currIndex", (currPage-1)*pageSize);
        data.put("pageSize", pageSize);
        System.out.println(data);
        List<Stu> p_list = stuMapper.Pagination(data);
        System.out.println(p_list);
        return p_list;
    }

    public static void main(String[] args) {
        StuService stuService = new StuServiceImpl();
        List<Stu> stuList = stuService.QueryAllStudents();
        for(int i=0;i<stuList.size();i++)
            System.out.println(stuList.get(i));
    }
}

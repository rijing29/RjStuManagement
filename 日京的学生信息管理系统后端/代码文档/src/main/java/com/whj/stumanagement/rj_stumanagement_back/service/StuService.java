package com.whj.stumanagement.rj_stumanagement_back.service;

import com.whj.stumanagement.rj_stumanagement_back.entity.Stu;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface StuService {
    //    根据学号删除学生信息
    boolean deleteByPrimaryKey(Integer sno);
    //    插入学生信息
    boolean insert(Stu record);
    //    查询所有学生的信息
    List<Stu> QueryAllStudents();
    //    根据学号来更新学生信息
    boolean updateByPrimaryKey(Stu record);
    //登录验证
    boolean login(String sname,String spwd);
//    分页查询
    List<Stu> Pagination(int currPage, int pageSize);
//    修改密码
    boolean resetPwd(int sno,String spwd);
//   根据sname拿到sno
    int getSno(String sname);
}

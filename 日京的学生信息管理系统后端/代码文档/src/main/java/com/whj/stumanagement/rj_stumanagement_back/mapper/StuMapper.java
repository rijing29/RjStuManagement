package com.whj.stumanagement.rj_stumanagement_back.mapper;

import com.whj.stumanagement.rj_stumanagement_back.entity.Stu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface StuMapper {
//删除
    int deleteByPrimaryKey(Integer sno);
//插入
    int insert(Stu record);
//
    int insertSelective(Stu record);

    Stu selectByPrimaryKey(Integer sno);

    int updateByPrimaryKeySelective(Stu record);

    int updateByPrimaryKey(Stu record);
//    查询所有学生的信息
    List<Stu> queryAllStudents();
//    登录验证
    Stu login(@Param("sname") String sname,@Param("spwd") String spwd);
//    分页查询
    List<Stu> Pagination(Map<String,Object> data);
//    修改密码
    int resetPwd(@Param("sno") int sno,@Param("spwd") String spwd);
//    根据sname拿到sno
    int getSno(@Param("sname")String sname);
}
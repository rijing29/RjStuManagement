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

    int deleteByPrimaryKey(Integer sno);

    int insert(Stu record);

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
}
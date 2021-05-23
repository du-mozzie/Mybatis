package com.du.dao;

import com.du.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {

    //根据指定老师的id查询学生
    List<Teacher> getTeacher(@Param("tid") int id);

    //子查询
    List<Teacher> getTeacher2(@Param("tid") int id);

}

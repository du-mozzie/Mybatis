package com.du.dao;

import com.du.pojo.Student;

import java.util.List;

public interface StudentMapper {

    //根据学生tid查询老师，子查询
    public List<Student> getStudent();

    //根据结果查询
    public List<Student> getStudent2();

}

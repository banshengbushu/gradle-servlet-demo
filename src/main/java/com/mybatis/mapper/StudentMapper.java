package com.mybatis.mapper;

import com.mybatis.model.Student;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface StudentMapper extends Mapper<Student> {
    int insert(Student record);

    List<Student> selectAll();

}
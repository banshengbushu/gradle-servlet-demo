package com.mybatis.mapper;
import com.mybatis.model.Student;

import java.util.List;

public interface StudentMapper {
    public int insertUser(Student record);

    public List<Student> selectAll();

    public void deleteUser();

    public List<Student> updateUser(Student record);
}
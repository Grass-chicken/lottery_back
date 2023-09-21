package com.example.demo.util.Mapper;

import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xiongtao
 * @date 2023--09--12
 */
@Repository
public interface StudentMapper {

//    List<User> getAllStudent();

    /**
     * 获取学生
     * @param id 学号
     * @return 学生
     */
    Student getById(@Param("id") String id);

    /**
     * 给学生分配老师
     * @param id 学生id
     * @param name 老师姓名
     * @param phone 老师电话
     */
    void distributeFuRongTch(@Param("id") String id, @Param("name") String name, @Param("phone") String phone);


    List<Student> getAll();

}

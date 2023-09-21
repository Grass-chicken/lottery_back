package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.util.Mapper.StudentMapper;
import com.example.demo.util.tools.StringPool;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiongtao
 * @date 2023--09--12
 */
@Service
@RequiredArgsConstructor
public class StudentService {

    private final  StudentMapper studentMapper;


    public StudentMapper getStudentMapper() {
        return studentMapper;
    }

    public Student getById(String id){
        return studentMapper.getById(id);
    }

    public String getStatus(Student student,String name){
        if (student == null) {
            return StringPool.USERNAME_NO_EXIST;
        } else if (!student.getName().equals(name.trim())) {
            return StringPool.WRONG_PASSWORD;
        } else {
            return StringPool.LOGIN_SUCCESSFUL;
        }
    }

    public List<Student> getAll(){
       return studentMapper.getAll();
    }

}

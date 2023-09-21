package com.example.demo.api;


import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.service.StudentService;
import com.example.demo.service.UserService;
import com.example.demo.util.rest.R;
import com.example.demo.util.tools.StringPool;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * 登录接口
 *
 * @Author:王景阳
 * @DateTime:2022/6/7 21:25
 */
@RestController
@RequiredArgsConstructor
public class LoginApi {

    private final UserService userService;

    private final StudentService studentService;

    @GetMapping("/login/{id}/{name}")
    public R<?> login(@PathVariable("id") String id, @PathVariable("name") String name) {
        User user = null;
        String msg = null;
        user = userService.findUserById(id);
        msg = userService.getStatus(user, name);
        if (user != null && user.getIsLottery() == 0) {
            user.setAddress("");
        }
        return R.data(user, msg);
    }

    /**
     * 抽取指导老师登录接口
     *
     * @param id   学生id
     * @param name 学生名字
     * @return 学生
     */
    @GetMapping("/logon/{id}/{name}")
    public R<?> logon(@PathVariable("id") String id, @PathVariable("name") String name) {
        Student student = studentService.getById(id);
        String msg = studentService.getStatus(student, name);
        if (student != null && student.getIsLottery() == 0) {
            student.setInstructor("");
        }
        return R.data(student, msg);
    }

    @GetMapping("/te")
    public LocalDateTime u() {
        return LocalDateTime.now();
    }

}

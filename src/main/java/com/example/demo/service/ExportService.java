package com.example.demo.service;

import com.alibaba.excel.EasyExcel;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * @Author:王景阳
 * @DateTime:2022/6/8 9:32
 */
@Service
@RequiredArgsConstructor
public class ExportService {

    private final UserService userService;

    private final StudentService studentService;
    /**
     * 将数据库中所有用户数据导出为 excel
     *
     * @param response
     * @throws Exception
     */
    public void exportExcel(HttpServletResponse response) throws Exception {
        response.reset();
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码，当然和easyexcel没有关系
        String fileName = URLEncoder.encode("实习分配名单.xlsx", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        EasyExcel.write(response.getOutputStream(), User.class)
                .sheet("学生列表").doWrite(userService.getAllUser());
    }

    public void exportPracticeE(HttpServletResponse response) throws Exception {
        response.reset();
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码，当然和easyexcel没有关系
        String fileName = URLEncoder.encode("指导老师分配名单.xlsx", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        EasyExcel.write(response.getOutputStream(), Student.class)
                .sheet("分配列表").doWrite(studentService.getAll());
    }
}

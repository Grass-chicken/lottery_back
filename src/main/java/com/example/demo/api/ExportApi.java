package com.example.demo.api;

import com.example.demo.service.ExportService;
import com.example.demo.util.tools.StringPool;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 导出接口
 *
 * @Author:王景阳
 * @DateTime:2022/6/7 21:38
 */
@Controller
@RequiredArgsConstructor
public class ExportApi {

    private final ExportService exportService;

    @GetMapping("/export/excel")
    public void exportExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        exportService.exportExcel(response);
    }

    @GetMapping("/export/instructor/excel")
    public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
        exportService.exportPracticeE(response);
    }

}

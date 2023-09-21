package com.example.demo.util.tools.excel;

/**
 * @Author:王景阳
 * @DateTime:2022/6/8 11:57
 */

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.demo.entity.User;

import java.util.Map;


public class ExcelListener extends AnalysisEventListener<User> {
    /**
     * 一行一行读取Excel中的内容
     */
    @Override
    public void invoke(User data, AnalysisContext analysisContext) {
        System.out.println(data);
    }


    /**
     * 读取表头
     */
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头："+headMap);
    }

    /**
     * 读取完成之后做的事
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}

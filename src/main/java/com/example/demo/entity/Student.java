package com.example.demo.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.enums.poi.BorderStyleEnum;
import com.alibaba.excel.enums.poi.HorizontalAlignmentEnum;
import com.alibaba.excel.enums.poi.VerticalAlignmentEnum;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

/**
 * @author xiongtao
 * @date 2023--09--12
 */
@Alias(value = "student")
@Getter
@Setter
@ContentStyle(borderLeft = BorderStyleEnum.DEFAULT, horizontalAlignment = HorizontalAlignmentEnum.CENTER, verticalAlignment = VerticalAlignmentEnum.CENTER)
public class Student {

    @ColumnWidth(value = 15)
    @ExcelProperty(value = "学号", index = 0)
    private String id;

    @ColumnWidth(value = 15)
    @ExcelProperty(value = "姓名", index = 1)
    private String name;

    @ColumnWidth(value = 15)
    @ExcelProperty(value = "班级", index = 2)
    private String belong;

    @ColumnWidth(value = 15)
    @ExcelProperty(value = "指导老师", index = 3)
    private String instructor;

    @ColumnWidth(value = 15)
    @ExcelProperty(value = "老师电话", index = 4)
    private String phone;

    /**
     * 是否已经抽奖
     */
    @ExcelIgnore
    private int isLottery;

    /**
     * 学生类型,1-本部学生,2-师范学生,3-芙蓉学生
     */
    @ExcelIgnore
    private int stuType;

}

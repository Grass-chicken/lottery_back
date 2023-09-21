package com.example.demo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentFontStyle;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.enums.poi.BorderStyleEnum;
import com.alibaba.excel.enums.poi.HorizontalAlignmentEnum;
import com.alibaba.excel.enums.poi.VerticalAlignmentEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author:王景阳
 * @DateTime:2022/6/14 19:05
 */
@Getter
@Setter
@ContentFontStyle
@ContentStyle(borderLeft = BorderStyleEnum.DEFAULT,horizontalAlignment = HorizontalAlignmentEnum.CENTER,verticalAlignment = VerticalAlignmentEnum.CENTER)
public class TestData {

    @ColumnWidth(value = 15)
    @ExcelProperty(value = "数据集名称", index = 0)
    String testId;

    @ColumnWidth(value = 15)
    @ExcelProperty(value = "id", index = 1)
    String id;

    @ColumnWidth(value = 15)
    @ExcelProperty(value = "name", index = 2)
    String name;

}

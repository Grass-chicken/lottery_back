package com.example.demo.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentFontStyle;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.enums.poi.BorderStyleEnum;
import com.alibaba.excel.enums.poi.HorizontalAlignmentEnum;
import com.alibaba.excel.enums.poi.VerticalAlignmentEnum;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.Objects;

/**
 * @Author:王景阳
 * @DateTime:2022/6/7 21:16
 */
@Alias(value = "user")
@Setter
@Getter
@ContentStyle(borderLeft = BorderStyleEnum.DEFAULT, horizontalAlignment = HorizontalAlignmentEnum.CENTER, verticalAlignment = VerticalAlignmentEnum.CENTER)
public class User {

    @ColumnWidth(value = 15)
    @ExcelProperty(value = "学号", index = 0)
    private String id;

    @ColumnWidth(value = 15)
    @ExcelProperty(value = "姓名", index = 1)
    private String name;

    @ColumnWidth(value = 15)
    @ExcelProperty(value = "性别", index = 2)
    private String sex;

    @ColumnWidth(value = 15)
    @ExcelProperty(value = "班级", index = 3)
    private String belong;

    @ExcelIgnore
    private int isLottery;

    @ColumnWidth(value = 30)
    @ExcelProperty(value = "工作地点", index = 4)
    private String address;

    @ExcelIgnore
    private int workId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return this.getId() == null ? System.identityHashCode(this) : this.getId().hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", belong='" + belong + '\'' +
                ", password='" + isLottery + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

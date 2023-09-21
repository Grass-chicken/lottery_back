package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

/**
 * @author xiongtao
 */
@Alias(value = "peopleInformation")
@Getter
@Setter
public class PeopleInformation {

    /**
     * id
     */
    String id;

    /**
     * name
     * fuRongNub:去本部老师的芙蓉学生个数
     * shiFanNub:去本部老师的师范学生个数
     * originNub:去本部老师的本部学生个数
     * lotusNub:去芙蓉老师的芙蓉学生个数
     */
    String name;

    /**
     * 人数
     */
    double number;


}

package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.Objects;

/**
 * @Author:王景阳
 * @DateTime:2022/6/7 21:16
 */
@Alias(value = "workAddress")
@Setter
@Getter
public class WorkAddress {

    private int id;

    /**
     * 实习地点
     */
    private String address;

    /**
     * 需要实习人数
     */
    private int amount;

    /**
     * 性别限制，默认为 “无”
     */
    private String sexLimit;

    /**
     * 内定人数
     */
    private int defaultNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WorkAddress)) {
            return false;
        }
        WorkAddress that = (WorkAddress) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "WorkAddress{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", amount=" + amount +
                ", sexLimit='" + sexLimit + '\'' +
                ", defaultNumber=" + defaultNumber +
                '}';
    }
}

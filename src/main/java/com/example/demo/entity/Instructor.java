package com.example.demo.entity;

import com.example.demo.util.Mapper.InstructorMapper;
import com.example.demo.util.Mapper.PeopleInformationMapper;
import com.example.demo.util.Mapper.StudentMapper;
import com.example.demo.util.tools.IocUtil;
import com.example.demo.util.tools.StringPool;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

/**
 * @author xiongtao
 * @date 2023--09--12
 */
@Alias(value = "instructor")
@Getter
@Setter
public class Instructor {

    /**
     * id
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 老师电话
     */
    private String phone;

    /**
     * 判断是否只带芙蓉学生
     */
    private int type;

    /**
     * 所带论文数量
     */
    private int amount;

    /**
     * 可带芙蓉学生数
     */
    protected double lotusStu;

    /**
     * 可带本部学生数
     */
    protected double originStu;

    public double getProbability(int stuType) {

        PeopleInformationMapper pMapper = IocUtil.get(PeopleInformationMapper.class);

        if (stuType == 1) {
            double nub = pMapper.getNubByName(StringPool.ORIGIN_NUB);
            return originStu / nub;
        } else {
            double nub = pMapper.getNubByName(StringPool.FU_RONG_NUB) + pMapper.getNubByName(StringPool.SHI_FAN_NUB);
            return lotusStu / nub;
        }
    }


    public void dynamicCalculate(Student stu) {
        PeopleInformationMapper pMapper = IocUtil.get(PeopleInformationMapper.class);
        StudentMapper studentMapper = IocUtil.get(StudentMapper.class);
        InstructorMapper instructorMapper = IocUtil.get(InstructorMapper.class);

        if (stu.getStuType() == StringPool.ORIGIN_STU) {
            instructorMapper.updateStuNub(id, 0, 1);
            pMapper.reduceNub(StringPool.ORIGIN_NUB, 1);
        } else if (stu.getStuType() == StringPool.SHI_FAN_STU) {
            instructorMapper.updateStuNub(id, 1, 0);
            pMapper.reduceNub(StringPool.SHI_FAN_NUB, 1);
        } else if (stu.getStuType() == StringPool.FU_RONG_STU) {
            instructorMapper.updateStuNub(id, 1, 0);
            pMapper.reduceNub(StringPool.FU_RONG_NUB, 1);
        }
        studentMapper.distributeFuRongTch(stu.getId(), name, phone);
    }

}

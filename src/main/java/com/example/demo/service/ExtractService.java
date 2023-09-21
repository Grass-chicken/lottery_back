package com.example.demo.service;

import cn.hutool.core.util.RandomUtil;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.Student;
import com.example.demo.util.Mapper.InstructorMapper;
import com.example.demo.util.Mapper.PeopleInformationMapper;
import com.example.demo.util.Mapper.StudentMapper;
import com.example.demo.util.tools.StringPool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiongtao
 * @date 2023--09--12
 */
@Service
@RequiredArgsConstructor
public class ExtractService {

    private final StudentMapper studentMapper;

    private final InstructorMapper instructorMapper;

    private final PeopleInformationMapper pMapper;


    public String randomGetInstructorId(String id) {
        synchronized (StringPool.LOCK) {
            String instructorId;
            Student stu = studentMapper.getById(id);
            if (stu.getIsLottery() == 0) {

                if (isGoFuRong(stu.getStuType())) {
                    instructorId = distributeFuRongTch(id);
                } else if (stu.getStuType() == StringPool.SHANG_WU_STU
                        || stu.getStuType() == StringPool.SHANG_WU_STU_FU_PIN) {
                    instructorId = distributeShangWuTch(stu);
                } else {
                    instructorId = distributeOriginTch(stu);
                }

            } else {
                instructorId = instructorMapper.getIdByName(stu.getInstructor());
            }
            return instructorId;
        }
    }


    /**
     * 随机抽取本部老师
     *
     * @param student 学生
     * @return 老师id
     */
    public String distributeOriginTch(Student student) {
        List<Instructor> instructors = instructorMapper.getOriginByType(StringPool.ORIGIN_TCH);

        //获取总概率
        double sumProbability = instructors.stream()
                .map(x -> x.getProbability(student.getStuType()))
                .reduce(0.0, Double::sum);

        for (Instructor ins : instructors) {
            if (ins.getProbability(student.getStuType()) > RandomUtil.randomDouble(0.0, 1.0) * sumProbability) {
                ins.dynamicCalculate(student);
                return ins.getId();
            }
            sumProbability = sumProbability - ins.getProbability(student.getStuType());
        }
        return null;
    }

    /**
     * 判断学生类型并选着可以抽取的老师
     *
     * @param stuType 1:本部学生,2:师范学生,3:芙蓉学生
     * @return 老师类型 T:芙蓉老师 F:本部老师
     */
    public boolean isGoFuRong(int stuType) {

        double fuRongStuTotal = pMapper.getNubByName(StringPool.LOTUS_NUB) + pMapper.getNubByName(StringPool.FU_RONG_NUB);

        if (stuType == StringPool.FU_RONG_STU) {
            return (int) (Math.random() * fuRongStuTotal + 1) <= pMapper.getNubByName(StringPool.LOTUS_NUB);
        }

        return false;
    }

    /**
     * 分配芙蓉老师给芙蓉学生
     *
     * @return 老师id
     */
    public String distributeFuRongTch(String id) {
        List<Instructor> list = instructorMapper.getByType(StringPool.FU_RONG_TCH);
        Instructor ins = list.get((int) (Math.random() * list.size()));
        instructorMapper.updateAmountById(ins.getId());
        studentMapper.distributeFuRongTch(id, ins.getName(), ins.getPhone());
        pMapper.reduceNub(StringPool.LOTUS_NUB, 1.0);
        return ins.getId();
    }

    /**
     * 抽取英商专业老师
     *
     * @return 英商老师
     */
    public String distributeShangWuTch(Student student) {
        List<Instructor> list;
        Instructor ins;

        if (student.getStuType() == StringPool.SHANG_WU_STU_FU_PIN) {
            list = instructorMapper.getFiPingTch();
            ins = list.get((int) (Math.random() * list.size()));
            instructorMapper.updateStuNub(ins.getId(), 1.0, 0);
        } else {
            list = instructorMapper.getShiFanTch();
            ins = list.get((int) (Math.random() * list.size()));
            instructorMapper.updateStuNub(ins.getId(), 0, 1.0);
        }

        studentMapper.distributeFuRongTch(student.getId(), ins.getName(), ins.getPhone());
        pMapper.reduceNub(StringPool.SHANG_WU_NUB, 1.0);
        return ins.getId();
    }
}
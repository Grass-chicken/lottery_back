package com.example.demo.util.Mapper;

import com.example.demo.entity.Instructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xiongtao
 * @date 2023--09--12
 */
@Repository
public interface InstructorMapper {
    int updateByName(@Param("id") String id, @Param("name") String name);

    void updateAmountById(@Param("id") String id);

    void updateStuNub(@Param("id")String id,double lotusStu,@Param("originStu") double originStu);
    List<Instructor> getAll();

    String getIdByName(@Param("name") String name );


    List<Instructor> getByType(@Param("type") int type);

    List<Instructor> getOriginByType(@Param("type") int type);

    List<Instructor> getFiPingTch();


    List<Instructor> getShiFanTch();
    /**
     * 初始化数据库用
     */
    int initStu(@Param("id") String id,@Param("lotusStu") double lotusStu,@Param("originStu") double originStu);


}

package com.example.demo.util.Mapper;

import com.example.demo.entity.PeopleInformation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xiongtao
 * @date 2023--09--15
 */
@Repository
public interface PeopleInformationMapper {

    List<PeopleInformation> getAll();

    double getNubByName(@Param("name") String name);

    void reduceNub(@Param("name") String name,@Param("nub") double nub);


}

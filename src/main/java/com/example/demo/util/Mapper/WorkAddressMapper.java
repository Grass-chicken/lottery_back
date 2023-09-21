package com.example.demo.util.Mapper;

import com.example.demo.entity.WorkAddress;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:王景阳
 * @DateTime:2022/6/7 22:02
 */
@Repository
public interface WorkAddressMapper {

    /**
     * 查询所有的工作地点
     * @return 工作地点
     */
    List<WorkAddress> getAllWorkAddress();

    WorkAddress getById(@Param("id") int id);

    /**
     * 通过 id 更新还需实习人数
     * @param id 实习地点 id
     * @param amount 还需实习人数
     */
//    boolean updateAmountById(@Param("id") int id, @Param("amount") int amount);

    boolean updateAmountById(@Param("id") int id, @Param("amount") int amount,@Param("userId") String userId);

    boolean updateDefaultNumberById(@Param("id") int id, @Param("defaultNumber") int defaultNumber);

}

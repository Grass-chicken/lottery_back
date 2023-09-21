package com.example.demo.util.Mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:王景阳
 * @DateTime:2022/6/7 22:01
 */
@Repository
public interface UserMapper {

    /**
     * 通过用户名（id）查询用户
     *
     * @param id 用户名
     * @return 用户
     */
    User findUserById(@Param("id") String id);

    List<User> getAllUser();

//    List<User> getAllByIsLotteryUserList(@Param("isLottery") String isLottery);

//    boolean updateAddressById(@Param("id") String id, @Param("address") String address);

    boolean updateAddressById(@Param("id") String id, @Param("address") String address,@Param("addressId") int addressId);

    boolean updateIsLotteryById(@Param("id") String id, @Param("isLottery") int isLottery);
}

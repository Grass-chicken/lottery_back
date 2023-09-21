package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.util.Mapper.UserMapper;
import com.example.demo.util.tools.StringPool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:王景阳
 * @DateTime:2022/6/8 9:14
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    /**
     * 获取所有用户
     */
    public List<User> getAllUser(){
        return userMapper.getAllUser();
    }

    /**
     * 通过 id 查找用户
     */
    public User findUserById(String id) {
        return  userMapper.findUserById(id);
    }

    public void updateAddressById(String id, String address,int addressId){
        userMapper.updateAddressById(id, address,addressId);
    }

    public void updateIsLotteryById(String id, int isLottery){
        userMapper.updateIsLotteryById(id, isLottery);
    }

    public String getStatus(User user, String name) {
        if (user == null) {
            return StringPool.USERNAME_NO_EXIST;
        } else if (!user.getName().equals(name.trim())) {
            return StringPool.WRONG_PASSWORD;
        } else {
            return StringPool.LOGIN_SUCCESSFUL;
        }
    }
}

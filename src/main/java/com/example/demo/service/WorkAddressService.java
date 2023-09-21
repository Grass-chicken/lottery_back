package com.example.demo.service;

import com.example.demo.entity.WorkAddress;
import com.example.demo.util.Mapper.WorkAddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:王景阳
 * @DateTime:2022/6/8 14:30
 */
@Service
@RequiredArgsConstructor
public class WorkAddressService{

    private final WorkAddressMapper workAddressMapper;

    public List<WorkAddress> getAllWorkAddress() {
        return workAddressMapper.getAllWorkAddress();
    }

    public void updateAmountById(int id, int amount, String userId) {
        workAddressMapper.updateAmountById(id, amount, userId);
    }

    public WorkAddress getById(int id){
        return workAddressMapper.getById(id);
    }

    public boolean updateDefaultNumberById(int id, int defaultNumber) {
        return workAddressMapper.updateDefaultNumberById(id, defaultNumber);
    }

}
package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.service.LotteryService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;



@Component
public class StartRun implements Runnable{

    @Autowired
    UserService userService;

    @Autowired
    LotteryService lotteryService;

    public StartRun(UserService userService, LotteryService lotteryService) {
        this.userService = userService;
        this.lotteryService = lotteryService;
    }

    @Override
    public void run() {
        List<TestData> data = getData();
        System.out.println(data.toArray().length);
        for (TestData datum : data) {
            System.out.println(datum.id);
            lotteryService.randomGetAddressId(datum.id);
        }
    }

    public List<TestData> getData() {
        List<User> userList = userService.getAllUser();
        List<TestData> list = new ArrayList<>();
        for (int i = 0; i < userList.size(); i++) {
            TestData testData = new TestData();
            testData.setId(userList.get(i).getId());
            testData.setTestId("数据集-" + (i + 1));
            testData.setName(userList.get(i).getName());
            list.add(testData);
        }
        return list;
    }
}
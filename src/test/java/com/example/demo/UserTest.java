package com.example.demo;

import com.example.demo.entity.Instructor;
import com.example.demo.entity.Student;
import com.example.demo.service.ExtractService;
import com.example.demo.service.LotteryService;
import com.example.demo.service.UserService;
import com.example.demo.util.Mapper.InstructorMapper;
import com.example.demo.util.Mapper.StudentMapper;
import com.example.demo.util.Mapper.UserMapper;
import com.example.demo.util.tools.IocUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Author:王景阳
 * @DateTime:2022/6/14 9:22
 */
public class UserTest extends DemoApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    LotteryService lotteryService;

    @Autowired
    StudentMapper studentMapper;

    @Autowired(required = false)
    UserMapper userMapper;

    @Autowired
    InstructorMapper instructorMapper;

    @Autowired
    ExtractService extractService;

    private CountDownLatch countDownLatch = new CountDownLatch(1);

//    @Test
//    public void exportTestData() {
//        createCVS();
//    }
//
//    @Test
//    public void StatisticsOfSchoolPopulation() {
//        Map<String, Integer> map = new HashMap<>();
//        map.put("津市德雅中学", 0);
//        map.put("澧县六中", 0);
//        map.put("桃花源一中", 0);
//        map.put("文昌中学", 0);
//        map.put("十三中", 0);
//        map.put("白马湖中学", 0);
//        List<User> allUser = userService.getAllUser();
//        for (User user : userService.getAllUser()) {
//            map.put(user.getAddress(), map.get(user.getAddress()) + 1);
//        }
//        for (Map.Entry<String, Integer> m : map.entrySet()) {
//            System.out.println(m.getKey() + "------->" + m.getValue());
//        }
//    }
//
//    private void createCVS() {
//        //实现excel写的操作
//        //1.设置写入文件夹的地址和excel文件名称
//        String fileName = "C:\\Users\\d\\Desktop\\测试数据集.csv";
//
//        //2.调用easyexcel里面方法实现写操作
//        //传入：文件存放的路径+对应的实体类class
//        EasyExcel.write(fileName, TestData.class).sheet("测试数据集").doWrite(getData());
//    }
//
//    //创建方法返回list集合（测试数据）
//    public List<TestData> getData() {
//
//        List<User> userList = userService.getAllUser();
//        List<TestData> list = new ArrayList<>();
//        for (int i = 0; i < userList.size(); i++) {
//            TestData testData = new TestData();
//            testData.setId(userList.get(i).getId());
//            testData.setTestId("数据集-" + (i + 1));
//            testData.setName(userList.get(i).getName());
//            list.add(testData);
//        }
//        return list;
//    }


    @Test
    public void threadedTesting() throws InterruptedException {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
//            int finalI = i;
            Thread t = new Thread(() -> {
                try {
                    countDownLatch.await();
                    List<Student> stu=studentMapper.getAll();
                    for (Student student : stu) {
                        extractService.randomGetInstructorId(student.getId());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
        countDownLatch.countDown();
        Thread.sleep(6000);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    @Test
    public void ss() {
        List<Instructor> list = instructorMapper.getAll();
        List<Student> stuAll = studentMapper.getAll();
        stuAll.forEach(x -> {
            extractService.randomGetInstructorId(x.getId());
        });

    }

}

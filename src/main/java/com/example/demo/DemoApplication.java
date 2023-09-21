package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

/**
 * @Author:王景阳
 * @DateTime:2022/6/7 21:42
 */

@SpringBootApplication
@MapperScan(
        //指定扫描包
        basePackages = {"com.example.demo.service", "com.example.demo.util.Mapper"},
        //指定SqlSessionFactory,如果sqlSessionTemplate被指定，则作废
        sqlSessionFactoryRef = "sqlSessionFactory",
        //指定sqlSessionTemplate，将忽略salSessionFactory配置
        sqlSessionTemplateRef = "sqlSessionTemplate",
        //限定扫描接口
        annotationClass = Repository.class)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

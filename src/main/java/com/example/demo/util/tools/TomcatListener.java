package com.example.demo.util.tools;

import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * tomcat监听器
 *
 * @Author:王景阳
 * @DateTime:2022/6/9 12:00
 */
@Component
public class TomcatListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("tomcat关闭了..........");
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("tomcate启动了..............");

    }

}
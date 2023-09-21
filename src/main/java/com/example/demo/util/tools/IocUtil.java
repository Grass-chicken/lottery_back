package com.example.demo.util.tools;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;

import java.util.Map;

/**
 * IocUtil
 *
 * @author ankelen
 * @date 2020-10-13 10:35
 */
@SuppressWarnings({"unchecked"})
public class IocUtil implements ApplicationContextAware {
    public static <T> T get(Class<T> clz) {
        return ctx.getBean(clz);
    }

    public static <T> T get(String name) {
        return ctx.containsBean(name) ? (T) ctx.getBean(name) : null;
    }

    public static <T> T get(String name, Class<T> clz) {
        return ctx.containsBean(name) ? ctx.getBean(name, clz) : null;
    }

    public static <T> Map<String, T> getMap(Class<T> clz) {
        return ctx.getBeansOfType(clz);
    }


    private static ApplicationContext ctx;

    @Override
    public void setApplicationContext(@NonNull ApplicationContext ctx) throws BeansException {
        IocUtil.ctx = ctx;
    }

    /**
     * 获取容器上下文
     *
     * @return Spring Container Context
     */
    public static ApplicationContext getCtx() {
        return ctx;
    }

    /**
     * 得到 SpringUtil 唯一实例
     */
    public static IocUtil getInstance() {
        return IocUtil.INSTANCE;
    }

    private static final IocUtil INSTANCE = new IocUtil();

    private IocUtil() {
    }
}

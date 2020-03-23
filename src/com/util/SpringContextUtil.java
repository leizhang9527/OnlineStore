package com.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Author: Decadence
 * @Email: leizhang9527@163.com
 * @Date: 2020/3/23 11:13
 * @Version 1.0
 */
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    /**
     * 实现ApplicationContextAware接口的回调方法，设置上下文环境
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext){
        SpringContextUtil.applicationContext = applicationContext;
    }

    /**
     * 获得spring上下文
     * @return ApplicationContext spring上下文
     */
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    /**
     * 获取bean
     * @param name service注解方式name为小驼峰格式
     * @return  Object bean的实例对象
     */
    public static Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);
    }
}

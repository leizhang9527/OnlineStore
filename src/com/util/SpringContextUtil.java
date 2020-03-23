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
     * ʵ��ApplicationContextAware�ӿڵĻص����������������Ļ���
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext){
        SpringContextUtil.applicationContext = applicationContext;
    }

    /**
     * ���spring������
     * @return ApplicationContext spring������
     */
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    /**
     * ��ȡbean
     * @param name serviceע�ⷽʽnameΪС�շ��ʽ
     * @return  Object bean��ʵ������
     */
    public static Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);
    }
}

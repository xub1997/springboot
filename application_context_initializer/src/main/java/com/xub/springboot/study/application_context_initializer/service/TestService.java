package com.xub.springboot.study.application_context_initializer.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author liqingxu
 * @Description
 * @create 2022-03-22
 */
@Component
public class TestService implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public String test1(){
        return applicationContext.getEnvironment().getProperty("key1");
    }

    public String test2(){
        return applicationContext.getEnvironment().getProperty("key2");
    }

    public String test3(){
        return applicationContext.getEnvironment().getProperty("key3");
    }
}

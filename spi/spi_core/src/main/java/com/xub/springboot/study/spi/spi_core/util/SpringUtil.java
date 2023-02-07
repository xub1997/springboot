package com.xub.springboot.study.spi.spi_core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author liqingxu
 * @Description
 * @create 2022-07-07
 */
@Component
public class SpringUtil implements ApplicationContextAware {

    private Logger log = LoggerFactory.getLogger(SpringUtil.class);

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("get applicationContext");
        this.applicationContext = applicationContext;
    }

    /**
     * 注册bean到spring容器中
     *
     * @param beanName 名称
     * @param clazz    class
     */
    public void registerBean(String beanName, Class<?> clazz) {
        // 通过BeanDefinitionBuilder创建bean定义
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
        //将applicationContext转换为ConfigurableApplicationContext
        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) configurableApplicationContext.getBeanFactory();
        // 注册bean
        defaultListableBeanFactory.registerBeanDefinition(beanName, beanDefinitionBuilder.getRawBeanDefinition());
        log.info("register bean [{}],Class [{}] success.", beanName, clazz);

    }

    /**
     * 删除spring容器中的bean
     *
     * @param beanName 名称
     */
    public void removeBean(String beanName, Class<?> clazz) {
        // 通过BeanDefinitionBuilder创建bean定义
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
        //将applicationContext转换为ConfigurableApplicationContext
        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) configurableApplicationContext.getBeanFactory();
        // 注册bean
        defaultListableBeanFactory.removeBeanDefinition(beanName);
        log.info("remove bean [{}] success.", beanName);

    }


    public Object getBean(String name) {
        return applicationContext.getBean(name);
    }
}

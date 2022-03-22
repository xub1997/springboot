package com.xub.springboot.study.application_context_initializer.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liqingxu
 * @Description
 * @create 2022-03-22
 */
@Order(3)
public class ThirdInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        Map map = new HashMap<>();
        map.put("key3", "value3");
        PropertySource<?> propertySource = new MapPropertySource("third_initializer", map);
        environment.getPropertySources().addLast(propertySource);
        System.out.println("run third_initializer");
    }
}

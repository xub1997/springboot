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
@Order(2)
public class SecondInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        ConfigurableEnvironment environment = configurableApplicationContext.getEnvironment();
        Map map = new HashMap<>();
        map.put("key2", "value2");
        PropertySource<?> propertySource = new MapPropertySource("second_initializer", map);
        environment.getPropertySources().addLast(propertySource);
        System.out.println("run second_initializer");
    }
}

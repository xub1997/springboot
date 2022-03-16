package com.xub.springboot.study.customized_stater.config;

import com.xub.springboot.study.customized_stater.service.CustomizedService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liqingxu
 * @Description
 * @create 2022-03-15
 */
@ConditionalOnProperty(prefix = "customized", value = "enabled", havingValue = "true")
@EnableConfigurationProperties(CustomizedProperties.class)
@Configuration
public class CustomizedAutoConfig {

    @Bean
    public CustomizedService customizedService(CustomizedProperties customizedProperties) {
        return new CustomizedService(customizedProperties);
    }
}

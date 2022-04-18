package com.xub.springboot.study.mybatis_interceptor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liqingxu
 * @Description
 * @create 2022-04-18
 */
@Configuration
public class MybatisConfig {

    @Bean
    public MybatisInterceptor mybatisInterceptor() {
        return new MybatisInterceptor();
    }
}

package com.xub.springboot.study.customized_starter_demo;

import com.xub.springboot.study.customized_starter_demo.common.IBaseMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.xub.common_mapper.dao",markerInterface = IBaseMapper.class)
@ComponentScan(basePackages = {"com.xub.common_mapper.common","com.xub.common_mapper"})
@EnableTransactionManagement
@SpringBootApplication
public class CommonMapperApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonMapperApplication.class, args);
    }

}


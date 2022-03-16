package com.xub.springboot.study.customized_stater.service;

import com.xub.springboot.study.customized_stater.config.CustomizedProperties;

/**
 * @author liqingxu
 * @Description
 * @create 2022-03-15
 */
public class CustomizedService {

    private CustomizedProperties customizedProperties;

    public CustomizedService(CustomizedProperties customizedProperties) {
        this.customizedProperties = customizedProperties;
    }

    public void hello() {
        System.out.println("Hello World!" + customizedProperties.getId() + "," + customizedProperties.getName());
    }
}

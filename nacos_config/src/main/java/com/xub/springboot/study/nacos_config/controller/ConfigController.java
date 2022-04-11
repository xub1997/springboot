package com.xub.springboot.study.nacos_config.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liqingxu
 * @Description
 * @create 2022-04-11
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @GetMapping
    public boolean get() {
        return useLocalCache;
    }
}

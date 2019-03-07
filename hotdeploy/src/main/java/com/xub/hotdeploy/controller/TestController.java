package com.xub.hotdeploy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description 测试热部署
 * @Author lqx
 * @Date 2019/3/7.23:32
 **/
@RestController
public class TestController {

    @GetMapping("/hotdeploy")
    public String hotdeploy(){
        return "hotdeploy";
    }
}

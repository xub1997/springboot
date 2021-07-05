package com.xub.springboot.study.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liqingxu
 * @desc HelloController
 * @date 2020/11/21 10:53
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello docker application!";
    }
}

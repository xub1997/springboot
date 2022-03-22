package com.xub.springboot.study.application_context_initializer.controller;

import com.xub.springboot.study.application_context_initializer.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liqingxu
 * @Description
 * @create 2022-03-22
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/")
    public void test() {
        System.out.println(testService.test1());
        System.out.println(testService.test2());
        System.out.println(testService.test3());
    }
}

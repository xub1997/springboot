package com.xub.springboot.study.type_inference.controller;

import com.xub.springboot.study.type_inference.pojo.User;
import com.xub.springboot.study.type_inference.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liqingxu
 * @Description
 * @create 2022-07-04
 */
@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public void test(){
        User user = new User();
        user.setId(1L);
        user.setUserName("admin");
        user.setPwd("123456");
        userService.service(user);
    }
}

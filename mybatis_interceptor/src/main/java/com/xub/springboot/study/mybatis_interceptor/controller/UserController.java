package com.xub.springboot.study.mybatis_interceptor.controller;


import com.xub.springboot.study.mybatis_interceptor.entity.User;
import com.xub.springboot.study.mybatis_interceptor.service.UserService;
import com.xub.springboot.study.mybatis_interceptor.utils.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseMsg insert(@Validated User user) {
        if (userService.save(user)) {
            return ResponseMsg.Success("保存成功");
        }
        return ResponseMsg.Error("保存失败");
    }


    @GetMapping("/user/{id}")
    public ResponseMsg getById(@PathVariable(value = "id") Integer id) {
        User user = userService.getById(id);
        if (user != null) {
            return ResponseMsg.Success("查询成功", user);
        }
        return ResponseMsg.Error("查询失败");
    }


    @DeleteMapping("/user/{id}")
    public ResponseMsg deleteById(@PathVariable(value = "id") Integer id) {
        if (userService.removeById(id)) {
            return ResponseMsg.Success("删除成功");
        }
        return ResponseMsg.Error("删除失败");
    }


    @GetMapping("/users")
    public ResponseMsg getAllUser() {
        List<User> users = userService.list();
        if (!CollectionUtils.isEmpty(users)) {
            return ResponseMsg.Success("查询成功", users);
        }
        return ResponseMsg.Error("查询失败");
    }

    @GetMapping("/user/test")
    public ResponseMsg test() {
        List<User> users = userService.test();
        if (!CollectionUtils.isEmpty(users)) {
            return ResponseMsg.Success("查询成功", users);
        }
        return ResponseMsg.Error("查询失败");
    }
}

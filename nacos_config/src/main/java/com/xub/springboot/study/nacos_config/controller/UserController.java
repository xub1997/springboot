package com.xub.springboot.study.nacos_config.controller;


import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.xub.springboot.study.nacos_config.entity.User;
import com.xub.springboot.study.nacos_config.service.UserService;
import com.xub.springboot.study.nacos_config.utils.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;


    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseMsg insert(@Validated User user){
        if(userService.insert(user)>0){
            return ResponseMsg.Success("保存成功");
        }
        return ResponseMsg.Error("保存失败");
    }


    @GetMapping("/user/{id}")
    public ResponseMsg getById(@PathVariable(value="id") Integer id){
        User user=userService.getById(id);
        if(user!=null){
            return ResponseMsg.Success("查询成功",user);
        }
        return ResponseMsg.Error("查询失败");
    }


    @DeleteMapping("/user/{id}")
    public ResponseMsg deleteById(@PathVariable(value="id") Integer id){
        if(userService.deleteById(id)>0){
            return ResponseMsg.Success("删除成功");
        }
        return ResponseMsg.Error("删除失败");
    }


    @GetMapping("/users")
    public ResponseMsg getAllUser(){
        List<User> users=userService.getAllUser();
        if(users!=null){
            return ResponseMsg.Success("查询成功",users);
        }
        return ResponseMsg.Error("查询失败");
    }
}

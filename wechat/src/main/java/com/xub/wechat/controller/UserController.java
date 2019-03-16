package com.xub.wechat.controller;

import com.xub.wechat.pojo.User;
import com.xub.wechat.service.UserService;
import com.xub.wechat.utils.ResponseData;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author lqx
 * @Date 2019/3/10.13:47
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    /*
    * 注册
    * */
    @PostMapping("/register")
    public ResponseData register(User user, HttpServletRequest request){
        return userService.register(user,request);
    }

    /*
    * 登录
    * */
    @PostMapping("/login")
    public ResponseData login(@RequestParam("username")String username,
                              @RequestParam("pwd")String pwd){
        return userService.login(username,pwd);
    }

    /*
    * 判断用户名重复
    * */
    @PostMapping("/judgeUsername")
    public ResponseData judgeUsername(@RequestParam("username")String username){
        if(userService.queryUsernameIsExist(username)){
            return ResponseData.error("用户名已存在");
        }else{
            return ResponseData.ok("用户名可用");
        }
    }

    /*
    *  根据id更新用户信息
    * */
    @PutMapping("/user")
    public ResponseData updateById(@RequestBody User user){
        return userService.upadteUserById(user);
    }

    /*
    * 根据用户名，查找用户（模糊查询）
    * */
    @PutMapping("/user/search")
    public ResponseData search(@RequestParam("username")String username){
        return userService.search(username );
    }

}

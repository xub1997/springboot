package com.xub.springboot.study.customized_starter_demo.service;

import com.xub.springboot.study.customized_starter_demo.dao.UserMapper;
import com.xub.springboot.study.customized_starter_demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService  {

    @Autowired
    UserMapper userMapper;

    public int insert(User user){
        return userMapper.insert(user);
    }
}

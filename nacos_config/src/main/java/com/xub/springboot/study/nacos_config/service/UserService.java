package com.xub.springboot.study.nacos_config.service;


import com.xub.springboot.study.nacos_config.entity.User;
import com.xub.springboot.study.nacos_config.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public  int insert(User user){
        return userMapper.insert(user);
    }

    public User getById(int id){
        return userMapper.getById(id);
    }

    public int deleteById(int id){
        return userMapper.deleteById(id);
    }

    public List<User> getAllUser(){
        return userMapper.getAllUser();
    }
}

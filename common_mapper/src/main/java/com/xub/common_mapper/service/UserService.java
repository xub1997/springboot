package com.xub.common_mapper.service;

import com.xub.common_mapper.dao.UserMapper;
import com.xub.common_mapper.entity.User;
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

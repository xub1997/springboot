package com.xub.springboot.study.type_inference.service.impl;

import com.xub.springboot.study.type_inference.mapper.UserMapper;
import com.xub.springboot.study.type_inference.pojo.User;
import com.xub.springboot.study.type_inference.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author liqingxu
 * @Description
 * @create 2022-07-04
 */
@Service
public class UserServiceImpl extends IServiceImpl<UserMapper, User> implements UserService {

    @Override
    public void service(User user) {
        getMapper().mapper(user);
    }
}

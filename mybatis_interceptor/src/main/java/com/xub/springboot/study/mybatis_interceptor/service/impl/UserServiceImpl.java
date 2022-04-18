package com.xub.springboot.study.mybatis_interceptor.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xub.springboot.study.mybatis_interceptor.service.UserService;
import com.xub.springboot.study.mybatis_interceptor.entity.User;
import com.xub.springboot.study.mybatis_interceptor.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liqingxu
 * @Description
 * @create 2022-04-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public List<User> test() {
        return this.baseMapper.test();
    }
}

package com.xub.springboot.study.mybatis_interceptor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xub.springboot.study.mybatis_interceptor.entity.User;

import java.util.List;

/**
 * @author liqingxu
 * @Description
 * @create 2022-04-18
 */
public interface UserService extends IService<User> {

    List<User> test();
}

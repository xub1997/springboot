package com.xub.springboot.study.mybatis_interceptor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xub.springboot.study.mybatis_interceptor.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liqingxu
 * @Description
 * @create 2022-04-18
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    List<User> test();
}

package com.xub.springboot.study.customized_starter_demo.dao;


import com.xub.springboot.study.customized_starter_demo.common.IBaseMapper;
import com.xub.springboot.study.customized_starter_demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper extends IBaseMapper<User> {
}

package com.xub.common_mapper.dao;


import com.xub.common_mapper.common.IBaseMapper;
import com.xub.common_mapper.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper extends IBaseMapper<User> {
}

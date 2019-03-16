package com.xub.wechat.mapper;

import com.xub.wechat.pojo.User;
import com.xub.wechat.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper extends MyMapper<User> {
    List<User> search(String username);
    User queryUserInfoByUsername(String username);
}
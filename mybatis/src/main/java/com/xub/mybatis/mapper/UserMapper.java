package com.xub.mybatis.mapper;


import com.xub.mybatis.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@Mapper
public interface UserMapper {

    @Insert("insert into tb_user(username,pwd) values(#{username},#{pwd})")
    Integer insert(User user);

    @Select("select * from tb_user where id=#{id}")
    User getById(int id);

    @Delete("delete from tb_user where id=#{id}")
    Integer deleteById(int id);

    @Select("select * from tb_user")
    List<User> getAllUser();
}

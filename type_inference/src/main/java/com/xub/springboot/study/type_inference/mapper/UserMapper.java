package com.xub.springboot.study.type_inference.mapper;

import com.xub.springboot.study.type_inference.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @author liqingxu
 * @Description
 * @create 2022-07-04
 */
@Component
public class UserMapper implements Mapper<User>{

    @Override
    public void mapper(User user) {
        System.out.println(user);
    }
}

package com.xub.springboot.study.customized_starter_demo;

import com.xub.springboot.study.customized_starter_demo.entity.User;
import com.xub.springboot.study.customized_starter_demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonMapperApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testCommon(){
        for(int i=0;i<100;i++){
            System.out.println(userService.insert(new User("123","34657")));
        }
    }

}


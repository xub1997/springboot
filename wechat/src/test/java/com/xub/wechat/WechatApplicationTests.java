package com.xub.wechat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatApplicationTests {


    @Test
    public void contextLoads() {
        //加密后的字符串
        String userid=UUID.randomUUID().toString().replaceAll("-","");
        String salt= userid.substring(10,30);
        String encodeStr= DigestUtils.md5DigestAsHex(("1234"+salt).getBytes());
        System.out.println("MD5加密后的字符串为:salt="+salt);
        System.out.println("MD5加密后的字符串为:encodeStr="+encodeStr);
        System.out.println("判断加密对错："+encodeStr.equals(DigestUtils.md5DigestAsHex(("1234"+salt).getBytes())));
    }


}

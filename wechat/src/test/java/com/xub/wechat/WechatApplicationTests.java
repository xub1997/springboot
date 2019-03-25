package com.xub.wechat;

import com.xub.wechat.config.NettyConfig;
import com.xub.wechat.config.PushConfig;
import com.xub.wechat.push.AppPush;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatApplicationTests {

    @Autowired
    NettyConfig nettyConfig;

    @Autowired
    PushConfig pushConfig;

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

    @Test
    public void test(){
        System.out.println(nettyConfig.getPort());
    }


    /*
    * d9a80244aee6e9148e90ae81080bfc98
    * bbf8f511d550bf2a96720ab3d92260f5
    * ded9a628e3c8251f23cd6eb7a3466d2c
    * */
    @Test
    public void testPush(){

        /*AppPush.pushToSingleWithNotificationTemplate(pushConfig,"第一条代码推送","推送内容",
                "d9a80244aee6e9148e90ae81080bfc98");*/
    }


}

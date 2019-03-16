package com.xub.wechat;

import com.xub.wechat.websocket.WSServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@ComponentScan({"com.xub.wechat","com.xub.wechat.config",
        "com.xub.wechat.controller","com.xub.wechat.service"})
@MapperScan("com.xub.wechat.mapper")
@SpringBootApplication
public class WechatApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WechatApplication.class, args);
    }

    @Bean
    public SpringUtil getSpingUtil() {
        return new SpringUtil();
    }

    @Override
    public void run(String... args) throws Exception {
        /*try {
            WSServer.getInstance().start();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }


}

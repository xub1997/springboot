package com.xub.autowired.bootstrap;

import com.xub.autowired.annotation.EnabledHelloWorld;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@EnabledHelloWorld
public class EnabledHelloWorldBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnabledHelloWorldBootstrap.class).run(args);
        String helloWorld = context.getBean("helloWorld", String.class);
        System.out.println(helloWorld);
        context.close();
    }
}

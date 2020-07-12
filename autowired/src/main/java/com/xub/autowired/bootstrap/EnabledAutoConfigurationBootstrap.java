package com.xub.autowired.bootstrap;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@EnableAutoConfiguration
public class EnabledAutoConfigurationBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnabledAutoConfigurationBootstrap.class)
                .run(args);
        String helloWorld = context.getBean("helloWorld", String.class);
        System.out.println(helloWorld);
        context.close();
    }
}

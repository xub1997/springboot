package com.xub.autowired.bootstrap;

import com.xub.autowired.annotation.ConditionalOnSystemProperty;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

public class ConditionalOnSystemPropertyBootstrap {

    @Bean
    @ConditionalOnSystemProperty(name = "user.name",value = "xub")
    public String condition(){
        return "conditional bean!";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalOnSystemPropertyBootstrap.class)
                .run(args);
        String condition = context.getBean("condition", String.class);
        System.out.println(condition);
        context.close();
    }
}

package com.xub.springboot.study.application_context_initializer;

import com.xub.springboot.study.application_context_initializer.initializer.SecondInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationContextInitializerApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ApplicationContextInitializerApplication.class);
        springApplication.addInitializers(new SecondInitializer());
        springApplication.run(args);
    }

}

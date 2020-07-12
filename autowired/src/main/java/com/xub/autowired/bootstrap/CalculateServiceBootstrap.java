package com.xub.autowired.bootstrap;

import com.xub.autowired.service.CalculateService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.xub.autowired.service")
public class CalculateServiceBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(CalculateServiceBootstrap.class)
                .profiles("Java8")
                .run(args);

        CalculateService bean = context.getBean(CalculateService.class);
        Integer sum = bean.sum(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(sum);
        context.close();
    }
}

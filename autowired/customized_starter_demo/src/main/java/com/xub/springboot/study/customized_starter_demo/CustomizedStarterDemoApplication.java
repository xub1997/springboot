package com.xub.springboot.study.customized_starter_demo;


import com.xub.springboot.study.customized_stater.EnabledCustomerStarter;
import com.xub.springboot.study.customized_stater.config.CustomizedAutoConfig;
import com.xub.springboot.study.customized_stater.service.CustomizedService;
import com.xub.springboot.study.customized_stater.service.CustomizedServiceByImportBeanDefinitionRegistrar;
import com.xub.springboot.study.customized_stater.service.CustomizedServiceByImport;
import com.xub.springboot.study.customized_stater.service.CustomizedServiceByImportSelector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@EnabledCustomerStarter
@SpringBootApplication
public class CustomizedStarterDemoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(CustomizedStarterDemoApplication.class, args);
        CustomizedAutoConfig customizedAutoConfig = configurableApplicationContext.getBean(CustomizedAutoConfig.class);
        System.out.println(customizedAutoConfig);
        CustomizedService customizedService = configurableApplicationContext.getBean(CustomizedService.class);
        System.out.println(customizedService);
        customizedService.hello();
        CustomizedServiceByImport customizedServiceByImport = configurableApplicationContext.getBean(CustomizedServiceByImport.class);
        System.out.println(customizedServiceByImport);
        customizedServiceByImport.hello();
        CustomizedServiceByImportSelector customizedServiceByImportSelector = configurableApplicationContext.getBean(CustomizedServiceByImportSelector.class);
        System.out.println(customizedServiceByImportSelector);
        customizedServiceByImportSelector.hello();
        CustomizedServiceByImportBeanDefinitionRegistrar customizedServiceByImportBeanDefinitionRegistrar = configurableApplicationContext.getBean(CustomizedServiceByImportBeanDefinitionRegistrar.class);
        System.out.println(customizedServiceByImportBeanDefinitionRegistrar);
        customizedServiceByImportBeanDefinitionRegistrar.hello();

    }

}


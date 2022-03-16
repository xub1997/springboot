package com.xub.springboot.study.customized_stater.definition_registrar;

import com.xub.springboot.study.customized_stater.service.CustomizedServiceByImportBeanDefinitionRegistrar;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

/**
 * @author liqingxu
 * @Description
 * @create 2022-03-15
 */
public class CustomizedDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        Class beanClass = CustomizedServiceByImportBeanDefinitionRegistrar.class;
        RootBeanDefinition beanDefinition = new RootBeanDefinition(beanClass);
        String beanName = StringUtils.uncapitalize(beanClass.getSimpleName());
        //在这里可以拿到所有注解的信息，可以根据不同注解来返回不同的class,从而达到开启不同功能的目的
        //通过这种方式可以自定义beanName
        beanDefinitionRegistry.registerBeanDefinition(beanName, beanDefinition);
    }
}

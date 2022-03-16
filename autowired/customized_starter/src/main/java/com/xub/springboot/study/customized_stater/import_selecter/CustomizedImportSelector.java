package com.xub.springboot.study.customized_stater.import_selecter;

import com.xub.springboot.study.customized_stater.EnabledCustomerStarter;
import com.xub.springboot.study.customized_stater.service.CustomizedServiceByImportSelector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author liqingxu
 * @Description
 * @create 2022-03-15
 */
@Slf4j
public class CustomizedImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(
                importingClassMetadata.getAnnotationAttributes(
                        EnabledCustomerStarter.class.getName()));
        if(annotationAttributes == null){
            log.info("@EnableLogger is not used on the main program");
            return new String[0];
        }
        //在这里可以拿到所有注解的信息，可以根据不同注解的和注解的属性来返回不同的class,
        // 从而达到开启不同功能的目的
        return new String[]{CustomizedServiceByImportSelector.class.getName()};
    }
}

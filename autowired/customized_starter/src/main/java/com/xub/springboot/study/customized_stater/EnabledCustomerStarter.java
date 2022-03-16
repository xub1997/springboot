package com.xub.springboot.study.customized_stater;

import com.xub.springboot.study.customized_stater.definition_registrar.CustomizedDefinitionRegistrar;
import com.xub.springboot.study.customized_stater.import_selecter.CustomizedImportSelector;
import com.xub.springboot.study.customized_stater.service.CustomizedServiceByImport;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liqingxu
 * @Description
 * @create 2022-03-15
 */
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({CustomizedServiceByImport.class, CustomizedImportSelector.class, CustomizedDefinitionRegistrar.class})
@ConditionalOnProperty(prefix = "customized", value = "enabled", havingValue = "true")
public @interface EnabledCustomerStarter {
}

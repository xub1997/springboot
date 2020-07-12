package com.xub.autowired.annotation;

import com.xub.autowired.condition.OnSystemPropertyCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {
    /**
     * Java系统属性的名称
     *
     * @return
     */
    String name();

    /**
     * Java系统属性名称对应值
     *
     * @return
     */
    String value();
}

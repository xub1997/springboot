package com.xub.autowired.condition;

import com.xub.autowired.annotation.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * 系统属性条件判断
 */
public class OnSystemPropertyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Map<String, Object> annotationAttributes = annotatedTypeMetadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
        String name = String.valueOf(annotationAttributes.get("name"));
        String value = String.valueOf(annotationAttributes.get("value"));
        String property = System.getProperty(name);
        return value.equals(property);
    }
}

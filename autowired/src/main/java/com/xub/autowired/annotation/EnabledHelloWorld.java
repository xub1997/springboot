package com.xub.autowired.annotation;

import com.xub.autowired.configuration.HelloWorldConfiguration;
import com.xub.autowired.selector.HelloWorldSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(HelloWorldConfiguration.class)
//@Import(HelloWorldSelector.class)
public @interface EnabledHelloWorld {
}
